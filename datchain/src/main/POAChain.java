package main;

import java.util.ArrayList;

public class POAChain extends ArrayList<Block> implements Blockchain {

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
        //TODO test validation of chain of hashes
        /*
        for (Block block : chain) {
            //Doesn't seem to work, how do we abstract a block interface and it's methods without specifying
            block.getHash();
        }

        //might not be able to use lambda expressions
        /*chain.forEach( block -> { try {

        }
        });
        return true;
        */
        return true;
    }
}
