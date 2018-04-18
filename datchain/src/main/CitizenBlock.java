package main;


import static java.time.Instant.now;

public class CitizenBlock implements Block {

    private String validatorIdent;
    private String validatorPubKey;
    private String citizenIdent;
    private String citizenPubKey;
    private String hash;
    private String prevHash;
    private int index;
    private long timestamp;

    public CitizenBlock(String validatorIdent, String validatorPubKey, String citizenIdent, String citizenPubKey, String prevHash) {
        this.validatorIdent = validatorIdent;
        this.validatorPubKey = validatorPubKey;
        this.citizenIdent = citizenIdent;
        this.citizenPubKey = citizenPubKey;
        this.prevHash = prevHash;
        //Unix Epoch
        this.timestamp = now().getEpochSecond();
    }

    public String computeHash() {
        String hashInput = validatorIdent + validatorPubKey + citizenIdent + citizenPubKey + prevHash + timestamp + index;

        //TODO implement SHA256-hash function with proper java.security exceptions

        return hashInput;
    }

    public String getHash() {
        return this.hash;
    }

    public String getPrevHash() {
        return this.prevHash;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getIndex() {
        return this.index;
    }

    public String getPubKey() {
        return this.citizenPubKey;
    }

    public String getIdentity() {
        return this.citizenIdent;
    }
}
