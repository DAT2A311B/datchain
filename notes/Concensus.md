# Concensus-algoritm
This document outlines the considerations and ideas behind a goverment-enforced registry of persons, their properties and ways of implementation

A genesis-authority, the appropiate government organ, is created first, possibly as the genesis-block. 
This authority has a RSA-keypair associated with it, allowing signing following validators identities and provides the initial step of trust and accountability for all further.

Validators should be persons working for this govermental organ with access to sufficient information to personally validate the information presented for forging the citizen-identity. These validators must also exist as an identity on the blockchain. RSA-signature should be utilized to provide proof of the validator being granted authority from the genesis-authority. Refer to `mockup.block` for specific thoughts on data-fields and processes.

Citizens would have only one 'active' identity-block at any time. Further work must be done on how a process to update an identity-block of a citizen. This block would hold information that Danish CPR already facilitates, this would be full name, D.O.B and notably public key-component, merging the functions of NemID and CPR into one. A field of the signing authority must also be included in each citizen-block for connecting the string of trust. This would also easily taint all identities forged by a possible malicious validator, although the system should be designed to minimize the risk of this scenario, it's important to design mechanisms for the eventuality.

## TODO
- Concensus-requirements - minimum amount of validators for a correctly forged identity
- Managing pending identities for forging - graphically/programmatically?
- Would the citizen have to actively interact in the forging-process?
- 
