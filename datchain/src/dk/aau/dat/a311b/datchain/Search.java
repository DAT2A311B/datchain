package dk.aau.dat.a311b.datchain;

//https://github.com/xdrop/fuzzywuzzy for fuzzy string matching
import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;

import java.util.ArrayList;
import java.util.List;

public class Search {

    private ArrayList<String> arraySource = new ArrayList<>();
    private List<ExtractedResult> searchResults = new ArrayList<>();
    private ArrayList<Block> blockResults = new ArrayList<>();

    public ArrayList<Block> FuzzySearchIdentity(String term, Blockchain chain, int cutoff) {

        //avoid OutOfBounds exception
        if (cutoff > chain.size()) cutoff = chain.size();

        //deep copy block.getIdentity to arraySource
        for (int i = 0; i < chain.size(); i++) {
            this.arraySource.add(chain.getBlock(i).getIdentity());
        }
        //run fuzzywuzzy on string-copy of identities with a size of cutoff
        searchResults = FuzzySearch.extractTop(term, arraySource, cutoff);

        //for cutoff, get blocks from chain, from searchResults and add to primitive arraylist
        for (ExtractedResult result : searchResults) {
            blockResults.add(chain.getBlock(result.getIndex()));
        }
        return blockResults;
    }

    public ArrayList<Block> FuzzySearchIdentityPublicKey(String term, Blockchain chain, int cutoff) {

        //avoid OutOfBounds exception
        if (cutoff > chain.size()) cutoff = chain.size();

        //deep copy block to arraySource
        for (int i = 0; i < chain.size(); i++) {
            this.arraySource.add(chain.getBlock(i).getIdentityPublicKey());
        }
        //run fuzzywuzzy on string-copy of public keys with a size of cutoff
        searchResults = FuzzySearch.extractTop(term, arraySource, cutoff);

        //for cutoff, get blocks from chain, from searchResults and add to primitive arraylist
        for (ExtractedResult searchResult : searchResults) {
            blockResults.add(chain.getBlock(searchResult.getIndex()));
        }
        return blockResults;
    }

}
