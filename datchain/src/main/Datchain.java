package main;

import java.util.ArrayList;
import java.util.List;

public class Datchain {

    public static void main(String[] args) {

        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", block01.getHash());
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", block02.getHash());

        System.out.println("try compare hashes: " + "\n" + block02.getPrevHash() + "\n" + block01.getHash() + "\n");

        Blockchain chain02 = new Blockchain();
        chain02.add(block01);
        chain02.add(block02);
        chain02.add(block03);

        System.out.println("n blocks in chain02: " + chain02.size());

        System.out.println("chain02 contains block01? " + chain02.contains(block01));

        System.out.println("index of block03: " + chain02.indexOf(block03));

        if (chain02.remove(2) == block03) System.out.println("Successfully removed block03");

        System.out.println("n blocks in chain02: " + chain02.size());

        if (chain02.validateChain()) System.out.println("chain02 validated!");
        chain02.getHead();

    }

}
