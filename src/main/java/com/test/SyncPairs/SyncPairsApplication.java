package com.test.SyncPairs;

import com.test.SyncPairs.service.SyncPairService;

public class SyncPairsApplication {

    public static void main(String args[]) {
        SyncPairService syncPairService = new SyncPairService();
//        syncPairService.addSynonymPair(null, "");
        syncPairService.addSynonymPair("hello", "hey");
        syncPairService.addSynonymPair("world", "earth");
        syncPairService.addSynonymPair("planet", "earth");
//        syncPairService.addSynonymPair("planet", "planet");

//        syncPairService.getSentences("hello world");
//        System.out.println("========NEW LINE========");
//
        syncPairService.addSynonymPair("hey", "hii");
        syncPairService.addSynonymPair("hii", "hey");
//
        syncPairService.getSentences("hello world");
//
//        System.out.println("========NEW LINE========");
//
//        syncPairService.removeSynonymPair("planet", "earth");

//        syncPairService.getSentences("hello world");
    }



}

// hey -> hello -> hii
