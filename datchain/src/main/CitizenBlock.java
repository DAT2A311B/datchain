package main;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.time.Instant.now;

public class CitizenBlock extends Block {

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
        //Unix Epoch
        this.timestamp = now().getEpochSecond();
        this.hash = computeHash();
    }

    public String computeHash() {
        //TODO should grab and implement chain-index
        String hashInput = validatorIdent + validatorPubKey + citizenIdent + citizenPubKey + prevHash + timestamp;

        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //TODO might be redundant or not proper error-handling
        assert messageDigest != null;

        //get hashInput as bytes in UTF-8 and update messageDigest
        messageDigest.update(hashInput.getBytes(StandardCharsets.UTF_8));
        //create digest byte-array with resulting hash and encode digest as hex-string
        return String.format("%064x", new BigInteger(1, messageDigest.digest()));
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

    public String getPubKey() {
        return this.citizenPubKey;
    }

    public String getIdentity() {
        return this.citizenIdent;
    }
}
