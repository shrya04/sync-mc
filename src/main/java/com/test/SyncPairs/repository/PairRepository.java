package com.test.SyncPairs.repository;

import com.test.SyncPairs.models.Synonym;

import java.util.HashMap;

public class PairRepository {

    HashMap<String, Synonym> synonymHashMap;

    public PairRepository(){
        synonymHashMap = new HashMap<>();
    }

    public void save(Synonym synonym) {
        synonymHashMap.put(synonym.getValue(), synonym);
    }

    public Synonym get(String str1) {
        return synonymHashMap.getOrDefault(str1,null);
    }
}
