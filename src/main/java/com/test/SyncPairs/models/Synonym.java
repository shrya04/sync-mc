package com.test.SyncPairs.models;

import java.util.ArrayList;
import java.util.List;

public class Synonym {

    String value;
    List<Synonym> to;

    public Synonym(String value) {
        this.value = value;
        to = new ArrayList<>();
    }

    public String getValue() {
        return value;
    }

    public List<Synonym> getTo() {
        return to;
    }



}
