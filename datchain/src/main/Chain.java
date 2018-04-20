package main;

import java.util.ArrayList;

class Chain<Block> extends ArrayList<Block> {

    public boolean addBlock(Block block) {
        //Should implement a validator check, if not genesis

        //use ArrayList add-method to actually add block
        add(block);

        return true;
    }


}
