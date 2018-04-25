package main;

public class Datchain {

    public static void main(String[] args) {

        GenesisBlock genesis01 = new GenesisBlock("Genesis", "GenesisPublicKey", "0000");

        ValidatorBlock validator01 = new ValidatorBlock("Validator", "ValidatorPublicKey", "ValidatorPrevHash", "GenesisSignature");
        ValidatorBlock validator02 = new ValidatorBlock("Validator", "ValidatorPublicKey", "ValidatorPrevHash", "GenesisSignature");
        ValidatorBlock validator03 = new ValidatorBlock("Validator", "ValidatorPublicKey", "ValidatorPrevHash", "GenesisSignature");

        CitizenBlock citizen01 = new CitizenBlock("Citizen Name1", "CitizenPublicKey", "4321j6hj7234kj5234n", validator01.getIdentity(), validator01.getIdentityPublicKey());
        CitizenBlock citizen02 = new CitizenBlock("Citizen Name2", "CitizenPublicKey", citizen01.getHash(), validator02.getIdentity(), validator02.getIdentityPublicKey());
        CitizenBlock citizen03 = new CitizenBlock("Citizen Name3", "CitizenPublicKey", citizen02.getHash(), validator03.getIdentity(), validator03.getIdentityPublicKey());

        Blockchain chain02 = new Blockchain();
        chain02.add(genesis01);
        chain02.add(validator01);
        chain02.add(validator02);
        chain02.add(validator03);
        
        chain02.add(citizen01);
        chain02.add(citizen02);
        chain02.add(citizen03);

        System.out.println("n blocks in chain02: " + chain02.size());

        System.out.println("chain02 contains citizen01? " + chain02.contains(citizen01));

        System.out.println("index of citizen03: " + chain02.indexOf(citizen03));

        System.out.println("chain02 validated: " + chain02.validateChain());

    }

}
