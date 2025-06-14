package com.leetcode.array;

public class MajorityElement {
    /*
     * Explanation :
     * Take the array [2,2,3,4]
     * the binary representation would be [0010,0010,0011,0100]
     * if we see from right to left the second bit is set in the majority of the
     * elements ,
     * we are using this as out intuition.
     * Since we have integers we will take 32 bits and for each elemeent we will
     * check what all bits are set,
     * if the number of bits set exceeds the majority , we set those bits in our
     * answer too .
     */
    public int majorityElement(int[] nums) {
        int element = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) { // expression to check whether the bit is set
                    count++;
                }
            }
            if (count > nums.length / 2) { // expression to set the bits
                element |= (1 << i);
            }
        }
        return element;
    }

    /*
     * This solution is by Moore's Voting Algorithm
     * We consider the first element to be the majority element and assign a vote of
     * 1 to it,
     * Next we traverse the array and then increase the votes if we encounter the
     * same element
     * and decrese the votes if different element is found , when the votes are zero
     * we look for the majority element again.
     */
    public int majorityElementMooresVoting(int[] nums) {
        int element = -1;
        int votes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                element = nums[i];
                votes = 1;
            } else {
                if (element == nums[i]) {
                    votes++;
                } else
                    votes--;
            }
        }
        votes = 0;
        for (int num : nums) {
            if (element == num) {
                votes++;
            }
        }
        return votes > nums.length / 2 ? element : -1;
    }
}
