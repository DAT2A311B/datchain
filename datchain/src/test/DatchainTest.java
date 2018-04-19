package test;

import main.*;
import org.junit.jupiter.api.Test;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.*;


class DatchainTest {

    @Test
    void testBlockDifferent() {
        //mostly learning, but might be useful
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        assertFalse(block01.equals(block02));
    }

    @Test
    void testBlockEqual() {
        //mostly learning, but might be useful
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        assertEquals(block01, block01);
    }

    @Test
    void testTimestampConstructor()  {
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "0000");
        assertEquals(now().getEpochSecond(),block01.getTimestamp());
    }

    @Test
    void testNameCongruency() {
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        assertEquals(block01.getIdentity(), "Citizen Name");
        //TODO Must also test validator info
    }

    @Test
    void testHashCongruency() {
        //naive by testing two identical objects, could be done more advanced
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        assertEquals(block01.getHash(),block02.getHash());
    }
    //TODO test validator and citizen RSA-congruency
}
