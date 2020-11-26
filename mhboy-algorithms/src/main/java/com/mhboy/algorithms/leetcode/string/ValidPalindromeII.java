package com.mhboy.algorithms.leetcode.string;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int right = s.length() - 1;
        int left = 0;
        while(left <= right){
            char charL = s.charAt(left);
            char charR = s.charAt(right);
            if(charL == charR){
                left++;
                right--;
                continue;
            }else{
                return isPalindrome(s.substring(left + 1, right + 1)) || isPalindrome(s.substring(left, right));
            }
        }
        return true;
    }

    public boolean isPalindrome(String s){
        int right = s.length() - 1;
        int left = 0;
        while(left <= right){
            char charL = s.charAt(left);
            char charR = s.charAt(right);
            if(charL == charR){
                left++;
                right--;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome("abc"));
    }
}
