package main;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.time.Instant.now;

public class GenesisBlock extends Block {

    private String genesisAuthorityIdentity;
    private String genesisAuthorityPubKey;
    private String hash;
    private String prevHash;
    private long timestamp;

    public GenesisBlock(String genesisAuthorityIdentity, String genesisAuthorityPubKey, String hash, String prevHash, long timestamp) {
        this.genesisAuthorityIdentity = genesisAuthorityIdentity;
        this.genesisAuthorityPubKey = genesisAuthorityPubKey;
        this.prevHash = prevHash;
        this.timestamp = now().getEpochSecond();
        this.hash = computeHash();
    }

    public String computeHash() {
        //TODO should grab and implement chain-index
        String hashInput = genesisAuthorityIdentity + genesisAuthorityPubKey + prevHash + timestamp;

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
    public String getIdentityPublicKey() {
        return this.genesisAuthorityPubKey;
    }

    @Override
    public String getIdentity() {
        return this.genesisAuthorityIdentity;
    }
}
