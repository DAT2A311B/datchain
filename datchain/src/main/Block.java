package main;

public interface Block {

    //shared functionality of all blocks
    String computeHash();
    String getHash();
    String getPrevHash();
    long getTimestamp();
    String getPubKey();
    String getIdentity();
}
