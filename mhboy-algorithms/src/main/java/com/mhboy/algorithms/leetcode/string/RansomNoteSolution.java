package com.mhboy.algorithms.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * <p>
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *  
 * <p>
 * Constraints:
 * <p>
 * You may assume that both strings contain only lowercase letters.
 */
class RansomNoteSolution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int len = ransomNote.length();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
            char target = ransomNote.charAt(i);
            if (magazine.contains(String.valueOf(target))) {
                Integer index = map.get(target);
                if (null != index) {
                    String tempString = magazine.substring(index + 1);
                    if (tempString.contains(String.valueOf(target))) {
                        map.put(target, tempString.indexOf(target) + index + 1);
                    } else {
                        return false;
                    }
                } else {
                    map.put(target, magazine.indexOf(target));
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNoteSolution solution = new RansomNoteSolution();
        System.out.println(solution.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}