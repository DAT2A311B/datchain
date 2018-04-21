package main;

import java.util.ArrayList;

class Chain<Block> extends ArrayList<Block> {

    public boolean addBlock(Block block) {

        //Should implement a validator check, if not genesis
        try {
            //if (validator)
            add(block);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
            return false;
        }

    }

    public Block getBlock(int index) {
        return get(index);
    }

    public boolean validateChain(Chain chain) {
        //TODO test validation of chain of hashes
        chain.forEach( block -> System.out.println("Block"));
        return true;
    }


}
