package main;

interface Blockchain {

    boolean addBlock();
    Block getHead();
    Block getBlock();
    boolean validateChain();

}
