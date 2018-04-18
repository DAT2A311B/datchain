package main;

public interface Block {

    //shared functionality of all blocks
    public getHash();
    public getPrevHash();
    public getTimestamp();
    public getPubKey();
    public getIdent();
}
