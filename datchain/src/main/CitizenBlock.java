package main;

import java.util.Date;

public class CitizenBlock implements Block {

    private String validatorIdent;
    private String validatorPubKey;
    private String citizenIdent;
    private String citizenPubKey;
    private String hash;
    private String prevHash;
    private long timestamp;

    public CitizenBlock(String validatorIdent, String validatorPubKey, String citizenIdent, String citizenPubKey, String prevHash) {
        this.validatorIdent = validatorIdent;
        this.validatorPubKey = validatorPubKey;
        this.citizenIdent = citizenIdent;
        this.citizenPubKey = citizenPubKey;
        this.prevHash = prevHash;
        this.timestamp = new Date().getTime();
    }


    public String getHash() {
        return this.hash;
    }

    @Override
    public String getPrevHash() {
        return this.prevHash;
    }

    @Override
    public long getTimestamp() {
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
