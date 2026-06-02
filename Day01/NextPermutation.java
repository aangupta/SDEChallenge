package Day01;
/*
https://leetcode.com/problems/next-permutation/description/

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

*/

//TC - O(n)
class Solution {

    // Swap two elements in the array
    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = temp;
    }

    // Reverse array from start to end
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);

            start++;
            end--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // pivotIndex = first decreasing element from right
        int pivotIndex = -1;

        // Step 1:
        // Find breakpoint such that:
        // nums[i] < nums[i + 1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivotIndex = i;
                break;
            }
        }

        // If no breakpoint exists,
        // array is in descending order
        // -> last permutation
        // Reverse to get first permutation
        if (pivotIndex == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2:
        // Find next greater element from right
        // and swap with pivot
        for (int i = n - 1; i > pivotIndex; i--) {
            if (nums[i] > nums[pivotIndex]) {
                swap(nums, i, pivotIndex);
                break;
            }
        }

        // Step 3:
        // Reverse right half to get
        // the next smallest lexicographical order
        reverse(nums, pivotIndex + 1, n - 1);
    }
}
