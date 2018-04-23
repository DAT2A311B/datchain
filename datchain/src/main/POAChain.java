package main;

import java.util.ArrayList;

public class POAChain extends ArrayList<BlockAbstract> implements Blockchain {

    @Override
    public boolean add(BlockAbstract block) {
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
    public BlockAbstract getHead() {
        BlockAbstract head;
        if (this.size() > 0) {
            head = this.get(this.size() - 1);
        } else {
            throw new RuntimeException("No blocks added, can't get head");
        }
        return head;
    }

    public BlockAbstract getBlock(int index) {
        BlockAbstract block;
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
