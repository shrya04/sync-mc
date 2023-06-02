package com.test.SyncPairs.exceptions;

public class SelfSynonymPairException extends RuntimeException{
    public SelfSynonymPairException(){
        super("Operation where synonyms key value is same, cannot be performed");
    }
}
