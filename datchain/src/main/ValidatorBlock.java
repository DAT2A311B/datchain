package main;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.time.Instant.now;

public class ValidatorBlock implements Block{

    //TODO validators should be authorised through RSA-signed challenge/hash from genesis authority
    private String genesisSignature;
    private String validatorIdent;
    private String validatorPubKey;
    private String hash;
    private String prevHash;
    private long timestamp;

    public ValidatorBlock(String genesisSignature, String validatorIdent, String validatorPubKey, String hash, String prevHash, long timestamp) {
        this.genesisSignature = genesisSignature;
        this.validatorIdent = validatorIdent;
        this.validatorPubKey = validatorPubKey;
        this.prevHash = prevHash;
        this.timestamp = now().getEpochSecond();
        this.hash = computeHash();
    }

    @Override
    public String computeHash() {
        //TODO should grab and implement chain-index
        String hashInput = validatorIdent + validatorPubKey + prevHash + timestamp + genesisSignature;

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

    @Override
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
        return validatorPubKey;
    }

    @Override
    public String getIdentity() {
        return validatorIdent;
    }
}