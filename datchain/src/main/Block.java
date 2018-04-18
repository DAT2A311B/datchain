package main;

public interface Block {

    //shared functionality of all blocks
    String getHash();
    String getPrevHash();
    long getTimestamp();
    String getPubKey();
    String getIdentity();
}
