package main;

import java.util.ArrayList;
import java.util.List;

public class Datchain {

    public static void main(String[] args) {

        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");

        //TODO consider using linked lists for another dimension of blocks - beware
        List<Block> chain01 = new ArrayList<>();

        chain01.add(block01);
        chain01.add(block02);
        chain01.add(block03);

        System.out.println("n blocks in chain01: " + chain01.size());
        

    }

}
