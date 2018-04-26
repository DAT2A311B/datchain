package dk.aau.dat.a311b.datchain;

//https://github.com/xdrop/fuzzywuzzy for fuzzy string matching
import me.xdrop.fuzzywuzzy.FuzzySearch;
import java.util.ArrayList;

public class Blockchain extends ArrayList<Block> implements Chain {

    public boolean addValidatedBlock(Block block, Block validator) {

        //check if block to be added is of GenesisBlock-type and if chainsize is 0
        if (GenesisBlock.class.isAssignableFrom(block.getClass()) && this.size() == 0) {
            System.out.println("Block is of GenesisBlock-type");

        //check if block to be added is of ValidatorBlock-type and if chainsize is greater than 0
        } else if (ValidatorBlock.class.isAssignableFrom(block.getClass()) && this.size() > 0) {
            System.out.println("Block is of ValidatorBlock-type and chain has at least one block");

        //check if block to be added is of CitizenBlock-type and if chainsize is greater than 0
        } else if (CitizenBlock.class.isAssignableFrom(block.getClass()) && this.size() > 1) {
            System.out.println("Block is of CitizenBlock-type and chain has at least two block");

        //if none match, block is not recognized and a fatal error has occurred
        } else {
            throw new RuntimeException("ERROR: Block supplied does not match any types known!");
        }

        //check if supplied validator block exists on chain, needs RSA-challenge as well
        if (this.contains(validator)) {
            System.out.println("Is validator");
            this.add(block);
        } else {
            throw new RuntimeException("Validator is not on chain, cannot guarantee authority");
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

    //TODO should be expanded to create another arraylist of blocks,
    //TODO should also utilise the ratio supplied by fuzzysearch to suggest a block, the user might be searching for
    public Block searchSingleIdentity(String term) {

        //create string-array for holding identities for searching
        ArrayList<String> arrayIdentity = new ArrayList<>();

        //iterate through chain and put identities in arrayIdentity, such that indices match between the two arrays
        for (int i = 0; i < this.size(); i++) {
            arrayIdentity.add(this.getBlock(i).getIdentity());
        }
        //return for this chain-object, the block that FuzzySearch ranks with the highest ratio depending on supplied term
        return this.getBlock( FuzzySearch.extractOne(term, arrayIdentity).getIndex() );
    }

    public Block searchSinglePublicKey(String term) {

        //create string-array for holding public keys for searching
        ArrayList<String> arrayPublicKeys = new ArrayList<>();

        //iterate through chain and put public keys in arrayPublicKeys, such that indices match between the two arrays
        for (int i = 0; i < this.size(); i++) {
            arrayPublicKeys.add(this.getBlock(i).getIdentity());
        }
        //return for this chain-object, the block that FuzzySearch ranks with the highest ratio depending on supplied term
        return this.getBlock( FuzzySearch.extractOne(term, arrayPublicKeys).getIndex() );
    }

    //ArrayList doesn't implement a .last() method, thus we implement one ourselves
    public Block getHead() {
        Block head;
 /*       if (this.size() > 0) {
            head = this.get(this.size() - 1);
        } else {
            throw new RuntimeException("No blocks added, can't get head");
        }
        */

        try {
            head = this.get(this.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("ERROR: No blocks added, cannot get head" + e.getMessage());
        } catch (RuntimeException e) {
            throw new RuntimeException("Fuck!");
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
