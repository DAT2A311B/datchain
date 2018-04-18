package test;

import main.CitizenBlock;
import org.junit.jupiter.api.Test;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class DatchainTest {

    @Test
    public void testTimestampConstructor() {
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "0000");
        assertEquals(now().getEpochSecond(),block01.getTimestamp());
    }

    @Test
    public void testNameCongruency() {
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        assertEquals(block01.getIdentity(), "Citizen Name");
        //TODO Must also test validator info
    }

    //TODO test validator and citizen RSA-congruency
}
