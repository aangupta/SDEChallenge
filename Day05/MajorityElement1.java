package Day05;



//Approach 2 : Computing frequency
//TC - O(n)
//SC - O(n)
class Solution {

    public int majorityElement(int[] nums) {

        int n = nums.length;

        // Stores frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of every element
        for (int num : nums) {

            frequencyMap.put(
                num,
                frequencyMap.getOrDefault(num, 0) + 1
            );
        }

        // Find element occurring more than n/2 times
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        // Problem guarantees majority element exists
        return -1;
    }
}