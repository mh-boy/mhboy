package com.mhboy.algorithms.leetcode.arr;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 *  
 * <p>
 * Constraints:
 * <p>
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 * <p>
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int i = m - 1;
        int j = n - 1;
        while(len > 0){
            int val;
            if(i < 0 ){
                val = nums2[j--];
            }else if(j < 0){
                val = nums1[i--];
            }else if(nums1[i] > nums2[j]){
                val = nums1[i--];
            }else{
                val = nums2[j--];
            }
            nums1[len - 1] = val;
            len--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray array = new MergeSortedArray();
        int[] a = new int[]{1,2,3,0,0,0};
        int[] b = new int[]{2,5,6};
        array.merge(a, 3, b, 3);
        System.out.println();
    }
}
