package Day07;

/* https://leetcode.com/problems/two-sum/description/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 
*/

class Solution {

    public int[] twoSum(int[] nums, int target) {
        // Stores:
        // number -> index
        Map<Integer, Integer> numberToIndexMap = new HashMap<>();

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            // Number required to reach target
            int requiredNumber = target - nums[currentIndex];

            // If required number already exists,
            // we found the answer
            if (numberToIndexMap.containsKey(requiredNumber)) {
                return new int[] { numberToIndexMap.get(requiredNumber), currentIndex };
            }

            // Store current number and its index
            numberToIndexMap.put(nums[currentIndex], currentIndex);
        }

        // Problem guarantees one valid answer,
        // but return added for safety
        return new int[] { -1, -1 };
    }
}
