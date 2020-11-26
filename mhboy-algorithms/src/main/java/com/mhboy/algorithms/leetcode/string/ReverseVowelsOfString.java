package com.mhboy.algorithms.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsOfString {
    private final static HashSet<Character> vowels = new HashSet(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int right = s.length() - 1;
        char[] resarr = new char[s.length()];
        int left = 0;
        while(left <= right){
            char charL = s.charAt(left);
            char charR = s.charAt(right);
            if(vowels.contains(charL) && vowels.contains(charR)){
                resarr[left++] = charR;
                resarr[right--] = charL;
            }else if(vowels.contains(s.charAt(left))){
                resarr[right--] = charR;
            }else if(vowels.contains(s.charAt(right))){
                resarr[left++] = charL;
            }else{
                resarr[left++] = charL;
                resarr[right--] = charR;
            }
        }
        return new String(resarr);
    }

    public static void main(String[] args) {
        ReverseVowelsOfString string = new ReverseVowelsOfString();
        string.reverseVowels(" ");
    }
}
