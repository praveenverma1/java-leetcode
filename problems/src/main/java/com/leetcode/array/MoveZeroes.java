package com.leetcode.array;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        Arrays.stream(nums)
                .forEach(System.out::println);
    }

    public void moveZeroes(int[] nums) {
        int low = 0;
        int high = low + 1;
        while (high < nums.length) {
            if (nums[low] == 0) {
                if (nums[high] == 0) {
                    high++;
                } else {
                    nums[low] = nums[high];
                    nums[high] = 0;
                    low++;
                    high++;
                }
            } else {
                low++;
                high++;
            }
        }
    }
}
