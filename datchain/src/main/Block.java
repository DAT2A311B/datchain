package main;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.time.Instant.now;

abstract class Block {

    private final String identity;
    private final String identityPublicKey;
    private final String prevHash;
    private final String hash;
    private final long timestamp;

    protected Block(String identity, String identityPublicKey, String prevHash, String hashInput) {
        this.identity = identity;
        this.identityPublicKey = identityPublicKey;
        this.prevHash = prevHash;
        this.timestamp = now().getEpochSecond();
        this.hash = computeHash(hashInput);
    }

    String computeHash(String hashInput) {

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

    public String getIdentity() {
        return this.identity;
    }

    public String getIdentityPublicKey() {
        return this.identityPublicKey;
    }
}


