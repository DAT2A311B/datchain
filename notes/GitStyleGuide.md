# Git style guide
Standards for collaborating on shared repositories

## Branches
- Choose descriptive names that adhere to contextual prefixes
E.g. for branching out "dev" to implement "feature", branch should be named "dev_feature".

- Avoid using fast-forwarding when merging branches
Using the fast-forwarding feature of git makes reading the network-history harder and VCS-errors harder to fix. Inflating version-history is a worthwhile sacrifice for readability. 

## Commit messages
