package main;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        this.index = calcIndex();
        //Unix Epoch
        this.timestamp = now().getEpochSecond();
        this.hash = computeHash();
    }

    public String computeHash() {
        String hashInput = validatorIdent + validatorPubKey + citizenIdent + citizenPubKey + prevHash + timestamp + index;

        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //TODO might be redundant or not proper error-handling
        assert messageDigest != null;

        //hash input bytewise and return hashed bytes as string
        messageDigest.update(hashInput.getBytes());
        return new String(messageDigest.digest());
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

    public int calcIndex() {
        //TODO implement getter method for finding number of current, total blocks in chain
        return 0;
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
