/*
https://leetcode.com/problems/sort-colors/description/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

*/

//Approach 1
class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

// Approach-2 - Find the freq of 0, 1 and 2, Then we can overwrite the array
// based on the frequencies of 0's, 1's, 2's.
// TC - O(n)
// SC - O(1)
class Solution {
    public void sortColors(int[] nums) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                cnt0++;
            else if (nums[i] == 1)
                cnt1++;
            else
                cnt2++;
        }

        for (int i = 0; i < cnt0; i++)
            nums[i] = 0;

        for (int i = cnt0; i < cnt0 + cnt1; i++)
            nums[i] = 1;

        for (int i = cnt0 + cnt1; i < cnt0 + cnt1 + cnt2; i++)
            nums[i] = 2;

    }
}

// Approach 3: Dutch National Flag
// TC - O(n)
// SC - O(1)
class Solution {

    // Swap two elements in array
    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;

        // low -> boundary for 0s
        // mid -> current element
        // high -> boundary for 2s
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // Dutch National Flag Algorithm
        while (mid <= high) {
            // Case 1:
            // Place 0 in left partition
            if (nums[mid] == 0) {
                swap(nums, low, mid);

                low++;
                mid++;
            }
            // Case 2:
            // 1 is already in correct partition
            else if (nums[mid] == 1) {
                mid++;
            }
            // Case 3:
            // Place 2 in right partition
            else {
                swap(nums, mid, high);

                high--;
                // Do NOT increment mid here
                // because swapped element
                // needs to be checked again
            }
        }
    }
}
