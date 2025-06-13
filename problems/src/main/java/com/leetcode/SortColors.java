package com.leetcode;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };
        // int[] nums = new int[] { 2, 0, 1 };
        sortColors.sortColors(nums);
        Arrays.stream(nums)
                .forEach(System.out::println);
    }

    /*
     * This is a simple implementation of Dutch National Flag Algorithm
     * we take three pointers - low , mid and high
     * low takes care of the 0s
     * mid takes care of the 1s , while ,
     * high takes care of the 2s
     */
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
