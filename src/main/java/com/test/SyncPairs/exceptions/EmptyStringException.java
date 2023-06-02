package com.test.SyncPairs.exceptions;

public class EmptyStringException extends  RuntimeException {

    public EmptyStringException(){
        super("Word cant be empty");
    }

}
