# Concensus-algoritm
This document outlines the considerations and ideas behind a goverment-enforced registry of persons, their properties and ways of implementation

## Genesis-authority
A genesis-authority, the appropiate government organ, is created first, possibly as the genesis-block. 
This authority has a RSA-keypair associated with it, allowing signing following validators identities and provides the initial step of trust and accountability for all further.

## Validators
Validators should be persons working for this govermental organ with access to sufficient information to personally validate the information presented for forging the citizen-identity. These validators must also exist as an identity on the blockchain. RSA-signature should be utilized to provide proof of the validator being granted authority from the genesis-authority. Refer to `mockup.block` for specific thoughts on data-fields and processes. There are 3 main conditions for establishing a validator, of which all 3 must be met.

- a) There must exist a fail-safe process of verifying the identity of a validator
- b) Eligibility to be able to stake identity should be difficult to obtain. 
- c) The procedure establishing an authority must be unfaltering, in order to uphold the integrity of the authority.

Criteria `a` could be satisfied with hash of validator information RSA-signed by genesis-authority. 

`Crypt(genesisPrivKey, SHA2(validatorIdent + validatorPubKey + timestamp + dob + hash + prevHash))`

Criteria `b` could be satisfied by strict usage and vetting of workers under the govermental organ responsible for the registry. Strict usage of the GenesisAuthority (GA) is a requirement, this is, inherently, the first link of trust in the chain and all following entries rely on the correctness of this authority.

Criteria `c` could be satisfied by proper safekeeping of keys and monitoring of validators working on the chain. The specific implementation of such a system can result in different levels of security and as such, will not be discussed beyond hardware.

## Citizens
Citizens would have only one 'active' identity-block at any time. Further work must be done on how a process to update an identity-block of a citizen. This block would hold information that Danish CPR already facilitates, this would be full name, D.O.B and notably public key-component, merging the functions of NemID and CPR into one. A field of the signing authority must also be included in each citizen-block for connecting the string of trust. This would also easily taint all identities forged by a possible malicious validator, although the system should be designed to minimize the risk of this scenario, it's important to design mechanisms for the eventuality.

## Forging of a identity-block
A validator could use his RSA-keypair to encrypt a hash of pieces of the identity with his private key and referring back to his own block-index or by means of public key. This would enable any passerby to verify that this person is in fact:

- a) A verified validator with no outstanding issues from genesis-authority
- b) Knew the exact information presented in the identity-block
- c) Optionally expended computing power on low-diff Proof-of-Work 

It could be possible, although unnecessary, to implement a minor Proof-of-Work component to the forging process:

`Crypt("crypt_key", "message")`

`Crypt(validatorPrivKey", "SHA2(validatorIdent + timestamp + prevHash + identityPubKey + identity + dob) + nonce") `

Including the citizen in question for forging their identity-block would allow specific questions to be asked and add another layer of certainty that the information contained within the block is correct. However, considering actual use-cases, it's improbable that governments would expend the effort and cost. 
Relying on existing registers and systems along with an ordinary application should suffice to at least keep existing security.

### Requiring `n` validators for forging
The most secure, but also most cumbersome, way of forging identity-blocks on the chain could be to take a page out of Etheriums book and, at random, assign pending identities to validators. This approach requires further levels of user-management within the system and possibly a service running on a secure server and as such, weakens the purpose of decentralisation. It will not be discussed further in this implementation.  

### Voiding a compromised identity-block
As a blockchain is not exactly real-time and trying to append verified data to each block is not possible on the actual chain, voiding an identity-block due to a lost or stolen private-key is difficult. A naïve way of approaching this problem would be, to simply assume that data contained on a recently updated chain is correct and that only the last instance of an identity, not to be confused with an identity-block, is the correct one. Implementing this approach necessitates a method to tell if an identity is equal to another, a SHA2-hash of significant data could be feasible. However, this brings new problems; what if the citizen chose to change names, what if two citizens has the same name and date-of-birth? Another field with an UUID must then be kept in each block, however, this defeats the purpose of utilising the public-key as an UUID for a citizen.

## Possible problems
- How can we tie two identity-blocks to the same citizen?
This is a specific problem to citizens changing names. A consideration must be made, whether or not to allow this citizen to remain anonymous in regards to their previous identity. Another system could be kept by government or police for cases where this information is necessary, if anonymity is chosen.
If linking of citizen-blocks is wanted, another field could be introduced into each citizen-block with a reference to the hash of their previous identity. This last approach also allows citizens and/or validators to dynamically choose whether or not they'd like the citizens name-change public.

- How can we tell two citizens apart, if their public-key is not static and their data is equal?
If a field in the citizen-block is included with a reference to the citizens previous citizen-block, then this field would possibly provide sufficient information to link different instances of the same identity through multiple citizen-blocks.

## TODO
- Managing pending identities for validator forging - graphically/programmatically?
