package main;

import java.util.ArrayList;

class Chain<Block> extends ArrayList<Block> {

    Chain<Block> datchain = new Chain<>();

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

    public Block getHead() {
        Block head = null;
        if (this.datchain.size() > 0) {
            head = this.datchain.get(this.datchain.size() - 1);
        } else {
            throw new RuntimeException("No blocks added, can't get head");
        }
        return head;
    }

    public Block getBlock(int index) {
        return get(index);
    }

    public boolean validateChain(Chain chain) {
        //TODO test validation of chain of hashes

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
    }


}
