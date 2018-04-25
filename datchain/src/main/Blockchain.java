package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Blockchain extends ArrayList<Block> implements Chain {

    @Override
    public boolean add(Block block) {
        //Should implement a validator check, if not genesis
        try {
            //if (validator)
            super.add(block);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
            return false;
        }
    }

    public Blockchain getChain() {
        return this;
    }

    //ArrayList doesn't implement a .last() method, thus we implement one ourselves
    public Block getHead() {
        Block head;
        if (this.size() > 0) {
            head = this.get(this.size() - 1);
        } else {
            throw new RuntimeException("No blocks added, can't get head");
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
            if ( !currHash.equals(nextPrevHash)) {
                return false;
            }

            //TODO should also test chain of RSA-signature from genesis to all validators and possibly citizens
        }
        //if no congruency errors are found, chain is valid
        return true;
    }
}
