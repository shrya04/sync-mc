package com.test.SyncPairs.service;

import com.test.SyncPairs.exceptions.EmptyStringException;
import com.test.SyncPairs.exceptions.SelfSynonymPairException;
import com.test.SyncPairs.models.Synonym;
import com.test.SyncPairs.repository.PairRepository;
import com.test.SyncPairs.utils.SynonymsUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SyncPairService {

    PairRepository repository;

    public SyncPairService() {
        repository = new PairRepository();
    }

    public void addSynonymPair(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            throw new EmptyStringException();
        }
        if (str1 == str2) {
            throw new SelfSynonymPairException();
        }

        Synonym syn1 = getOrCreateNewSyn(str1);
        Synonym syn2 = getOrCreateNewSyn(str2);

        syn1.getTo().add(syn2);
        syn2.getTo().add(syn1);

        repository.save(syn1);
        repository.save(syn2);

    }

    private Synonym getOrCreateNewSyn(String string) {
        Synonym word = repository.get(string);
        if (word == null) {
            word = new Synonym(string);
        }
        return word;
    }

    public void getSentences(String sentence) {
        String[] words = sentence.split(" ");
        HashMap<String, List<String>> synonymsMap = new HashMap<String, List<String>>();
        for (String word : words) {
            Synonym synonym = repository.get(word);
            List<String> synonymStrings = new ArrayList<>();
            SynonymsUtils.getSynonyms(synonym, synonymStrings);
            Collections.sort(synonymStrings);
            synonymsMap.put(word, synonymStrings);
        }
        SynonymsUtils.printSentences(synonymsMap, sentence);
    }

    public void removeSynonymPair(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            throw new EmptyStringException();
        }
        Synonym syn1 = getOrCreateNewSyn(str1);
        Synonym syn2 = getOrCreateNewSyn(str2);
        if (syn1 == syn2) {
            throw new SelfSynonymPairException();
        }
        SynonymsUtils.remove(syn1, syn2);
        SynonymsUtils.remove(syn2, syn1);
        repository.save(syn1);
        repository.save(syn2);
    }
}
