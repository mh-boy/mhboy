package com.mhboy.algorithms.leetcode.sort;

/**
 *Given an array of integers nums, sort the array in ascending order.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class HeapSort {

    private void sink(int[] arr, int k, int N){
        while(2 * k <= N){
            int j = 2 * k;
            //find bigger son node
            if(j < N && arr[j - 1] < arr[j]) {
                j++;
            }
            //all son node less cur node , break
            if(arr[j - 1] < arr[k - 1]) {
                break;
            }
            //sink cur node to the bigger son node
            int t = arr[j -1 ];
            arr[j - 1] = arr[k - 1 ];
            arr[k - 1] = t;
            //next loop
            k = j;
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int k = n/2; k >=1 ; k--) {
            sink(nums, k, nums.length);
        }

        while(n > 1){
            int t = nums[0];
            nums[0] = nums[n-1];
            nums[n - 1] = t;
            n--;
            sink(nums, 1, n);
        }
        return nums;
    }


}
