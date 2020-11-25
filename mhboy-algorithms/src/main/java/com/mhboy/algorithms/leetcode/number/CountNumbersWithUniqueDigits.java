package com.mhboy.algorithms.leetcode.number;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * <p>
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 8
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        if (n > 10) return countNumbersWithUniqueDigits(10);

        int res = 1;
        for (int i = n; i > 1; i--) {
            res = (10 - i + 1) * res;
        }
        res *= 9;
        return countNumbersWithUniqueDigits(n - 1) + res;
    }
}
