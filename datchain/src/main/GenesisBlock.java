package main;

public class GenesisBlock extends Block {

    public GenesisBlock(String identity, String identityPublicKey, String hash, String prevHash) {
        super(identity, identityPublicKey, prevHash, identity + identityPublicKey + prevHash);
    }

}
