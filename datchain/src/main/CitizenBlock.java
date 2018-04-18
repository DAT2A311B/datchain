package main;

public class CitizenBlock implements Block {

    private String validatorIdent;
    private String validatorPubKey;
    private String citizenIdent;
    private String citizenPubKey;
    private String hash;
    private String prevHash;
    private int timestamp;

    public CitizenBlock(String validatorIdent, String validatorPubKey) {
        this.validatorIdent = validatorIdent;
        this.validatorPubKey = validatorPubKey;
    }

    @Override
    public String getHash() {
        return this.hash;
    }

    @Override
    public String getPrevHash() {
        return this.prevHash;
    }

    @Override
    public int getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String getPubKey() {
        return this.citizenPubKey;
    }

    @Override
    public String getIdentity() {
        return this.citizenIdent;
    }
}
