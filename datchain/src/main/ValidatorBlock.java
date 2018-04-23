package main;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.time.Instant.now;

public class ValidatorBlock extends Block {

    //TODO validators should be authorised through RSA-signed challenge/hash from genesis authority
    private String genesisSignature;
    private String identity;
    private String identityPublicKey;
    private String hash;
    private String prevHash;
    private long timestamp;

    public ValidatorBlock(String genesisSignature, String identity, String identityPublicKey, String hash, String prevHash, long timestamp) {
        this.genesisSignature = genesisSignature;
        this.identity = identity;
        this.identityPublicKey = identityPublicKey;
        this.prevHash = prevHash;
        this.timestamp = now().getEpochSecond();
        //is using getters better than using already assigned parameters?
        this.hash = computeHash(getIdentity() + getIdentityPublicKey() +
        getPrevHash() + getTimestamp() + getGenesisSignature());
    }

    private String getGenesisSignature() {
        return this.genesisSignature;
    }
}
