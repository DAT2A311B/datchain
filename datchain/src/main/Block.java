package main;

public interface Block {

    //shared functionality of all blocks
    public String getHash();
    public String getPrevHash();
    public int getTimestamp();
    public String getPubKey();
    public String getIdentity();
}
