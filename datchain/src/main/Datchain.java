package main;

public class Datchain {

    public static void main(String[] args) {

        ValidatorBlock validator01 = new ValidatorBlock("Validator", "ValidatorPublicKey", "ValidatorPrevHash", "GenesisSignature");
        ValidatorBlock validator02 = new ValidatorBlock("Validator", "ValidatorPublicKey", "ValidatorPrevHash", "GenesisSignature");
        ValidatorBlock validator03 = new ValidatorBlock("Validator", "ValidatorPublicKey", "ValidatorPrevHash", "GenesisSignature");

        CitizenBlock citizen01 = new CitizenBlock("Citizen Name1", "CitizenPublicKey", "4321j6hj7234kj5234n", validator01.getIdentity(), validator01.getIdentityPublicKey());
        CitizenBlock citizen02 = new CitizenBlock("Citizen Name2", "CitizenPublicKey", citizen01.getHash(), validator01.getIdentity(), validator01.getIdentityPublicKey());
        CitizenBlock citizen03 = new CitizenBlock("Citizen Name3", "CitizenPublicKey", citizen02.getHash(), validator01.getIdentity(), validator01.getIdentityPublicKey());

        System.out.println("try compare hashes: " + "\n" + citizen02.getPrevHash() + "\n" + citizen01.getHash() + "\n");

        Blockchain chain02 = new Blockchain();
        chain02.add(citizen01);
        chain02.add(citizen02);
        chain02.add(citizen03);

        System.out.println("n blocks in chain02: " + chain02.size());

        System.out.println("chain02 contains citizen01? " + chain02.contains(citizen01));

        System.out.println("index of citizen03: " + chain02.indexOf(citizen03));

        System.out.println();

        if (chain02.validateChain()) System.out.println("chain02 validated!");
        else System.out.println("chain02 NOT validated!");

    }

}
