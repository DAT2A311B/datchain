package main;

import java.security.NoSuchAlgorithmException;

public interface Block {

    //shared functionality of all blocks
    String computeHash();
    String getHash();
    String getPrevHash();
    int getIndex();
    int calcIndex();
    long getTimestamp();
    String getPubKey();
    String getIdentity();
}
