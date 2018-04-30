package dk.aau.dat.a311b.datchain;

//https://github.com/xdrop/fuzzywuzzy for fuzzy string matching
import me.xdrop.fuzzywuzzy.FuzzySearch;
import java.util.ArrayList;

public class Blockchain extends ArrayList<Block> {

    public boolean addValidatedBlock(Block block, Block validator) {

        //if local, current chain is not valid, abort adding block
        if (!this.validateChain()) return false;

        //check if block to be added is of GenesisBlock-type and if chainsize is 0
        if (GenesisBlock.class.isAssignableFrom(block.getClass()) && this.size() == 0) {
            System.out.println("Block is of GenesisBlock-type");
            //TODO validate genesis-block by polling network resources for an existing, older chain, if not assume genuine
            this.add(block);

        //check if block to be added is of ValidatorBlock-type and if chainsize is greater than 0
        } else if (ValidatorBlock.class.isAssignableFrom(block.getClass()) && this.size() > 0) {
            System.out.println("Block is of ValidatorBlock-type and chain has at least one block");
            //TODO encrypt hash of proposed ValidatorBlock with public-key of genesis, confirming the authority of genesis
            //TODO might need a builder-pattern for proper execution
            this.add(block);

        //check if block to be added is of CitizenBlock-type and if chainsize is greater than 0
        } else if (CitizenBlock.class.isAssignableFrom(block.getClass()) && this.size() > 1) {
            System.out.println("Block is of CitizenBlock-type and chain has at least two block");
            //TODO encrypt hash of proposed CitizenBlock with public-key of validator, confirming the authority of the validator
            //TODO might need a builder-pattern for proper execution
            this.add(block);

        //if none match, block is not recognized and a fatal error has occurred
        } else {
            throw new RuntimeException("ERROR: Block supplied does not match any types known!");
        }
        return true;
    }

    //might not be necessary, however signature doesn't match when addValidatedBlock is considered
    @Override
    public boolean add(Block block) {
        try {
            super.add(block);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
            return false;
        }
    }

    public boolean validateChain() {

        //stop loop short one of this.size() as last block will not have .next()
        for (int i = 0; i < this.size() - 1; i++) {

            //assign hashes to new strings for code legibility
            String currHash = getBlock(i).getHash();
            String nextPrevHash = getBlock(i+1).getPrevHash();

            //debug sout
            if (false) {
                System.out.println("block at index currHash" + i + ": " + currHash);
                System.out.println("block at index prevHash" + (i + 1) + ": " + nextPrevHash + "\n");
            }

            //check hash congruency through blocks
            if ( !currHash.equals(nextPrevHash) ) {
                return false;
            }

            //TODO should also test chain of RSA-signature from genesis to all validators and possibly citizens
        }
        //if no congruency errors are found, chain is valid
        return true;
    }

    //ArrayList doesn't implement a .last() method, thus we implement one ourselves
    public Block getHead() {

        Block head;
        try {
            //throw exception if no blocks are added, probably not the prettiest handling
            if (this.size() == 0) throw new RuntimeException("ERROR: No blocks added, cannot get head");
            head = this.get(this.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("ERROR: No blocks added, cannot get head" + e.getMessage());
        }
        return head;
    }

    public Block getBlock(int index) {
        Block block;
        try {
            block = get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Index out of bounds, can't get block");
        }
        return block;
    }

    public Blockchain getChain() {
        return this;
    }

}
