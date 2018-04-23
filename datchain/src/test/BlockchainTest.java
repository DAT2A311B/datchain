package test;

import main.CitizenBlock;
import main.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockchainTest {

    @Test
    void add() {
        Blockchain chain = new Blockchain();
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");

        assertTrue(chain.add(block01));
        assertTrue(chain.add(block02));
        assertTrue(chain.add(block03));
    }

    @Test
    void getHead() {
        Blockchain chain = new Blockchain();
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");

        assertTrue(chain.add(block01));
        assertTrue(chain.add(block02));
        assertTrue(chain.add(block03));

        assertEquals(block03, chain.getHead());
    }

    @Test
    void getBlock() {
        Blockchain chain = new Blockchain();
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");

        assertTrue(chain.add(block01));
        assertTrue(chain.add(block02));
        assertTrue(chain.add(block03));

        assertEquals(block02, chain.getBlock(1));
        assertEquals(block03, chain.getBlock(2));
    }

    @Test
    void validateChain() {
        Blockchain chain = new Blockchain();
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");

        assertTrue(chain.add(block01));
        assertTrue(chain.add(block02));
        assertTrue(chain.add(block03));

        assertTrue(chain.validateChain());

    }
}