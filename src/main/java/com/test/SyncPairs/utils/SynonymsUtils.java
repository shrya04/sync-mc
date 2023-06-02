package com.test.SyncPairs.utils;

import com.test.SyncPairs.models.Synonym;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SynonymsUtils {

    public static void getSynonyms(Synonym word, List<String> synonymStrings) {

        if (synonymStrings.contains(word.getValue())) {
            return;
        }
        synonymStrings.add(word.getValue());

        List<Synonym> synonymList = word.getTo();
        for (Synonym syns : synonymList) {
            getSynonyms(syns, synonymStrings);
        }
    }

    public static void printSentences(HashMap<String, List<String>> synonymsMap, String sentence) {
        backtrack(synonymsMap, sentence.split(" "), 0, new ArrayList<>(), sentence);
    }

    private static void backtrack(HashMap<String, List<String>> synonymsMap, String[] sentence, int index, List<String> words, String originalSentence) {
        if (words.size() == sentence.length) {
            String ans = String.join(" ", words);
            if (!ans.equals(originalSentence)) {
                System.out.println(ans);
            }
        } else {
            String currentWord = sentence[index];
            List<String> synonymWords = synonymsMap.getOrDefault(currentWord, null);
            if (synonymWords.isEmpty() || synonymWords == null) {
                words.add(currentWord);
            } else {
                for (String w : synonymWords) {
                    words.add(w);
                    backtrack(synonymsMap, sentence, index + 1, words, originalSentence);
                    words.remove(words.size() - 1);
                }
            }
        }
    }

    public static void remove(Synonym syn1, Synonym syn2) {
        int index = -1;
        for(int i = 0;i< syn1.getTo().size();i++){
            if(Objects.equals(syn1.getTo().get(i).getValue(), syn2.getValue())){
                index =i;
            }
        }
        if(index!=-1){
            syn1.getTo().remove(index);
        }
    }

}
