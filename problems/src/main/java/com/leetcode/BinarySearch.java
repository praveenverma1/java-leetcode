package com.leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(nums, 9);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return binarySearch(nums, 0, mid - 1, target);
        return binarySearch(nums, mid + 1, high, target);
    }
}
