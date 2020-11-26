package com.mhboy.algorithms.leetcode.number;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * Example 2:
 * <p>
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Example 3:
 * <p>
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 *  
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 3 * 104
 * -1000 <= nums[i] <= 1000
 * nums is sorted in increasing order.
 * -1000 <= target <= 1000
 * <p>
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++){
            int subTarget = target - numbers[i];
            int right = numbers.length - 1;
            int left = i+1;

            while(right >= left){
                int mid = (right - left) / 2 + left;
                if(numbers[mid] == subTarget){
                    return new int[]{i + 1, mid + 1};
                }else if(numbers[mid] < subTarget){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        return new int[]{-1,-1};
    }
}
