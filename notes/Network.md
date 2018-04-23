# Network considerations

1. When a validator verifies an identity, it is are broadcast to all nodes
2. Each validator collects pending identities, verfies them and broadcast them to all nodes
3. When the nth validator verifies an identity, that validator creates the block and broadcast it to all nodes
3.1. Nodes accept the proposed block only if it satisfies the chain of hashes and RSA-challenges.
4. Correctly working nodes will continue working on the longest, valid chain, ensuring a 50% Byzantine Fault Tolerance.

The block should contain a list of the n validators who has validated the identity along with a hash of common information, preferably encrypted in a chain with private keys of each successive validator.
