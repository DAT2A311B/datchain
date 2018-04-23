package main;

import java.util.ArrayList;

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
        return true;
    }
}
