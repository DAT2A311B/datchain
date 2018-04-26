package main;

public class ValidatorBlock extends Block {

    //TODO validators should be authorised through RSA-signed challenge/hash from genesis authority
    private final String genesisSignature;

    public ValidatorBlock(String identity, String identityPublicKey, String prevHash, String genesisSignature) {
        //call super-constructor with all variables as hashInput
        super(identity, identityPublicKey, prevHash, identity + identityPublicKey + prevHash + genesisSignature);
        this.genesisSignature = genesisSignature;
    }

    public String getGenesisSignature() {
        return this.genesisSignature;
    }
}
