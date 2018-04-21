package main;

import java.util.ArrayList;
import java.util.List;

public class Datchain {

    public static void main(String[] args) {

        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", block01.getHash());
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");

        System.out.println("try hashes: " + "\n" + block02.getPrevHash() + "\n" + block01.getHash() + "\n");

        //TODO consider using linked lists for another dimension of blocks - beware
        List<Block> chain01 = new ArrayList<>();
        chain01.add(block01);
        chain01.add(block02);
        chain01.add(block03);

        System.out.println("n blocks in chain01: " + chain01.size());

        Chain<Block> chain02 = new Chain<>();
        chain02.addBlock(block01);
        chain02.addBlock(block02);
        chain02.addBlock(block03);

        System.out.println("n blocks in chain02: " + chain02.size());

        System.out.println("chain02 contains block01? " + chain02.contains(block01));

        System.out.println("index of block03: " + chain02.indexOf(block03));

        chain02.remove(2);

        System.out.println("n blocks in chain02: " + chain02.size());

        chain02.validateChain(chain02);

    }

}
