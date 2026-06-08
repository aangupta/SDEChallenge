package Day08;

/*

https://takeuforward.org/plus/dsa/problems/count-subarrays-with-given-xor-k

Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.


Example 1
Input : nums = [4, 2, 2, 6, 4], k = 6
Output : 4
Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

Example 2
Input :nums = [5, 6, 7, 8, 9], k = 5
Output : 2
Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]

Example 3
Input : nums = [5, 2, 9], k = 7
Output:1

*/

class Solution {
    public int subarraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;

        // Step 1: Generate subarrays
        for (int i = 0; i < n; i++) {
            int xorr = 0;
            for (int j = i; j < n; j++) {
                /*
                 * Step 2: Calculate XOR of
                 * all elements in the subarray
                 */
                xorr = xorr ^ nums[j];

                // Step 3: Check XOR and count
                if (xorr == k)
                    cnt++;
            }
        }
        return cnt;
    }
}

// Approach 2
class Solution {

    public int subarraysWithXorK(int[] nums, int k) {
        // Stores:
        // prefixXor -> frequency
        Map<Integer, Integer> prefixXorFrequency = new HashMap<>();

        int currentXor = 0;
        int subarrayCount = 0;

        // Handles the case when
        // prefix XOR itself becomes k
        prefixXorFrequency.put(0, 1);

        for (int num : nums) {
            // Update running XOR
            currentXor ^= num;

            // We need a previous XOR such that:
            // previousXor ^ currentXor = k
            //
            // Therefore:
            // previousXor = currentXor ^ k
            int requiredXor = currentXor ^ k;

            // Add all occurrences of requiredXor
            if (prefixXorFrequency.containsKey(requiredXor)) {
                subarrayCount += prefixXorFrequency.get(requiredXor);
            }

            // Store current XOR frequency
            prefixXorFrequency.put(currentXor, prefixXorFrequency.getOrDefault(currentXor, 0) + 1);
        }

        return subarrayCount;
    }
}