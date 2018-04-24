package main;

public class CitizenBlock extends Block {

    private String validatorIdentity;
    private String validatorPublicKey;

    public CitizenBlock(String identity, String identityPublicKey, String prevHash, String validatorIdentity, String validatorPublicKey) {
        super(identity, identityPublicKey, prevHash, identity + identityPublicKey + prevHash + validatorIdentity + validatorPublicKey);
        this.validatorIdentity = validatorIdentity;
        this.validatorPublicKey = validatorPublicKey;

    }


}
