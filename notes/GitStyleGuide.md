# Git style guide
Standards for collaborating on shared repositories

## Branches
- Choose descriptive names that adhere to contextual prefixes
E.g. for branching out "dev" to implement "feature", branch should be named "dev_feature".

- Avoid using fast-forwarding when merging branches
Using the fast-forwarding feature of git makes reading the network-history harder and VCS-errors harder to fix. Inflating version-history is a worthwhile sacrifice for readability. 

## Commit messages
- Each commit should be a single logical change. Don't make several logical changes in one commit.
E.g. if some work consists of a bug-fix and a performance optimization, split these pieces of work into two commits.

- Don't split a single logical change into several commits. 
E.g. the implementation of a feature and the corresponding tests should be in the same commit.

- Commits should be ordered logically.
E.g. if feature Y depends on feature X, X should be committed first.
