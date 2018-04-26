import dk.aau.dat.a311b.datchain.ValidatorBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorBlockTest {

    @Test
    void testGetGenesisSignature() {
        ValidatorBlock validator01 = new ValidatorBlock("Validator", "ValidatorPublicKey", "0000", "GenesisSignature");
        assertEquals("GenesisSignature", validator01.getGenesisSignature());
    }

}