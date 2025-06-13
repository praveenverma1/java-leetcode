package com.leetcode;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
        int k = 2;
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, k);
        Arrays.stream(nums)
                .forEach(System.out::println);
    }

    public void rotate(int[] nums, int k) {
        int start = 0;
        int count = 0;
        int n = nums.length;
        k = k % n;
        while (count < n) {
            int current = start;
            int prev = nums[current];
            int next = (current + k) % n;
            while (next != start) {
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                next = (current + k) % n;
                count++;
            }
            nums[start] = prev;
            start++;
            count++;
        }
    }
}
