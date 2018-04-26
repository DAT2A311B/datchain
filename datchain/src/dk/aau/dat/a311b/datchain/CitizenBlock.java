package dk.aau.dat.a311b.datchain;

public class CitizenBlock extends Block {

    private final String validatorIdentity;
    private final String validatorPublicKey;

    public CitizenBlock(String identity, String identityPublicKey, String prevHash, String validatorIdentity, String validatorPublicKey) {
        super(identity, identityPublicKey, prevHash, identity + identityPublicKey + prevHash + validatorIdentity + validatorPublicKey);
        this.validatorIdentity = validatorIdentity;
        this.validatorPublicKey = validatorPublicKey;

    }


}
