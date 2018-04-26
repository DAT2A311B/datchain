import dk.aau.dat.a311b.datchain.Blockchain;
import dk.aau.dat.a311b.datchain.CitizenBlock;
import dk.aau.dat.a311b.datchain.GenesisBlock;
import dk.aau.dat.a311b.datchain.ValidatorBlock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockchainTest {

    @Test
    void addValidatedBlock() {
    }

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
    void validateChain() {
        Blockchain chain = new Blockchain();

        GenesisBlock genesis01 = new GenesisBlock("Genesis", "GenesisPublicKey", "0000");

        ValidatorBlock validator01 = new ValidatorBlock("Validator", "ValidatorPublicKey", genesis01.getHash(), "GenesisSignature");
        ValidatorBlock validator02 = new ValidatorBlock("Validator", "ValidatorPublicKey", validator01.getHash(), "GenesisSignature");
        ValidatorBlock validator03 = new ValidatorBlock("Validator", "ValidatorPublicKey", validator02.getHash(), "GenesisSignature");

        CitizenBlock citizen01 = new CitizenBlock("Citizen Name1", "CitizenPublicKey", validator03.getHash(), validator01.getIdentity(), validator01.getIdentityPublicKey());
        CitizenBlock citizen02 = new CitizenBlock("Citizen Name2", "CitizenPublicKey", citizen01.getHash(), validator02.getIdentity(), validator02.getIdentityPublicKey());
        CitizenBlock citizen03 = new CitizenBlock("Citizen Name3", "CitizenPublicKey", citizen02.getHash(), validator03.getIdentity(), validator03.getIdentityPublicKey());


        assertTrue(chain.add(genesis01));
        assertTrue(chain.add(validator01));
        assertTrue(chain.add(validator02));
        assertTrue(chain.add(validator03));
        assertTrue(chain.add(citizen01));
        assertTrue(chain.add(citizen02));
        assertTrue(chain.add(citizen03));

        assertTrue(chain.validateChain());
    }

    @Test
    void searchSingleIdentity() {
    }

    @Test
    void searchSinglePublicKey() {
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
    void getChain() {
        Blockchain chain = new Blockchain();
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");

        assertTrue(chain.equals(chain.getChain()));

    }
}