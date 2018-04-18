package test;

import main.CitizenBlock;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DatchainTest {

    @Test
    public void testTimestampConstructor() {
        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "0000");
        assertEquals(new Date().getTime(),block01.getTimestamp());
    }
}
