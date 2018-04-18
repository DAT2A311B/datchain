package main;

public class Datchain {

    public static void main(String[] args) {

        CitizenBlock block01 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block02 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");
        CitizenBlock block03 = new CitizenBlock("Validator","ValidatorPubkey", "Citizen Name", "CitizenPubKey", "9817324939382");

        System.out.println(block01.getHash());
        System.out.println(block02.getHash());
        System.out.println(block03.getHash());
    }

}
