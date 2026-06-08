package Day08;

/*

https://takeuforward.org/plus/dsa/problems/longest-subarray-with-sum-k?source=strivers-sde-sheet
Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.


Example 1

Input: nums = [10, 5, 2, 7, 1, 9],  k=15

Output: 4

Explanation:

The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

Example 2

Input: nums = [-3, 2, 1], k=6

Output: 0

Explanation:

There is no sub-array in the array that sums to 6. Therefore, the output is 0.

Example 3

Input: nums = [-1, 1, 1], k=1

Output:

3
Constraints

 1<=n<=105
 -10 ^ 5<=nums[i]<=10 ^ 5
 -10 ^ 9<= k<=10 ^ 9
 */

//Brute Force 
// TC - O(n ^ 2)
// SC - O(1)
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int currSum = 0;
            int length = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                length++;
                if (currSum == k) {
                    maxLen = Math.max(maxLen, length);
                }

            }
        }
        return maxLen;

    }
}

// Approach 2 : Prefix Sum Concept
class Solution {

    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Stores:
        // prefixSum -> first occurrence index
        Map<Integer, Integer> prefixSumToIndexMap = new HashMap<>();

        int currentSum = 0;
        int maxLength = 0;

        for (int index = 0; index < n; index++) {
            currentSum += nums[index];

            // Case 1:
            // Subarray from 0 to index has sum = k
            if (currentSum == k) {
                maxLength = Math.max(maxLength, index + 1);
            }

            // Case 2:
            // Find previous prefix sum such that:
            // currentSum - previousPrefixSum = k
            int requiredPrefixSum = currentSum - k;

            if (prefixSumToIndexMap.containsKey(requiredPrefixSum)) {
                int subarrayLength = index - prefixSumToIndexMap.get(requiredPrefixSum);

                maxLength = Math.max(maxLength, subarrayLength);
            }

            // Store only first occurrence
            // to maximize subarray length
            if (!prefixSumToIndexMap.containsKey(currentSum)) {
                prefixSumToIndexMap.put(currentSum, index);
            }
        }

        return maxLength;
    }
}
