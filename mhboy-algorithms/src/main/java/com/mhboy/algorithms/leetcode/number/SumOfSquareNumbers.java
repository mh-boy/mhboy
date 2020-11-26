package com.mhboy.algorithms.leetcode.number;

/**
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * <p>
 * Input: c = 3
 * Output: false
 * Example 3:
 * <p>
 * Input: c = 4
 * Output: true
 * Example 4:
 * <p>
 * Input: c = 2
 * Output: true
 * Example 5:
 * <p>
 * Input: c = 1
 * Output: true
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= c <= 231 - 1
 *
 * incorrect
 *
 *
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if (c == 0) {
            return true;
        }

        int targetPow = 0;
        for (int i = 30; i >= 0; i--) {
            int val = c >> i;
            if (val > 0) {
                targetPow = i;
                break;
            }
        }

        int dividePow = (targetPow / 2 - 1) >= 0 ? (targetPow / 2 - 1) : 0;
        for(int i = (1 << dividePow); i <= (1 << (targetPow/2)); i++){
            int target = c - i * i;
            if(target == 0){
                return true;
            }
            int lowNumTargetPow = 0;
            for (int j = 30; j >=0; j--) {
                int val = target >> j;
                if (val > 0) {
                    lowNumTargetPow = j;
                    break;
                }
            }
            for(int j = (1 << (lowNumTargetPow/2)); j < (1 << (lowNumTargetPow/2 + 1)); j++){
                if(target == j*j) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SumOfSquareNumbers numbers = new SumOfSquareNumbers();
        System.out.println(numbers.judgeSquareSum(9));
    }


}
