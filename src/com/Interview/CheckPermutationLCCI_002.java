package com.Interview;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutationLCCI_002 {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> characterMap1 = getCharacterMap(s1);
        Map<Character, Integer> characterMap2 = getCharacterMap(s2);
        for (Character character : characterMap1.keySet()) {
            if (characterMap1.get(character) != characterMap2.get(character) || characterMap2.get(character) == 0) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getCharacterMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            Character character = s.charAt(index);
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        CheckPermutationLCCI_002 checkPermutationLCCI_002 = new CheckPermutationLCCI_002();
        checkPermutationLCCI_002.CheckPermutation("abc", "bad");
    }
}
