package main;

import java.util.ArrayList;
import java.util.List;

class Chain<Block> extends ArrayList<Block> {

    //TODO must override default method
    void add() {
        System.out.println("add block");
    }


}
