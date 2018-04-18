package main;

public interface Block {

    //shared functionality of all blocks
    String computeHash();
    String getHash();
    String getPrevHash();
    int getIndex();
    long getTimestamp();
    String getPubKey();
    String getIdentity();
}
