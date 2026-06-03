/*
https://leetcode.com/problems/maximum-subarray/description/
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

//Approach 1: Kadane's Algo
//TC - O(n)
//SC - O(1)
class Solution {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        // Stores current subarray sum
        int currentSum = 0;

        for (int num : nums) {
            // Extend current subarray
            currentSum += num;

            // Update maximum subarray sum
            maxSum = Math.max(maxSum, currentSum);

            // If current sum becomes negative,
            // discard the subarray
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}

//Approach 2 : Divide and Conquer (Merge Sort)
//TC - O(nlogn)
//SC - O(logn)
