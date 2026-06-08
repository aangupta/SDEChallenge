package Day08;
/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

//Brute Force
//TC - O(n ^ 2)
//SC - O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int maxLen = 0;

        // Try every index as the starting point of the substring
        for (int i = 0; i < n; i++) {
            int[] lastSeen = new int[128];
            Arrays.fill(lastSeen, -1);

            int len = 0;

            // Extend the substring until a duplicate character is found
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                // If the character has not appeared in the current substring
                if (lastSeen[ch] == -1) {
                    lastSeen[ch] = j;
                    len++;
                    maxLen = Math.max(maxLen, len);
                }
                // Duplicate found, so this substring cannot be extended further
                else {
                    break;
                }
            }
        }

        return maxLen;
    }
}

// Approach 2 : Using Sliding Window
// Tc - O(N)
// SC - O(1)

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int maxLength = 0;

        // Sliding window boundaries
        int left = 0;

        // Frequency array for ASCII characters
        int[] frequency = new int[128];

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // Include current character in window
            frequency[currentChar]++;

            // Shrink window until duplicate is removed
            while (frequency[currentChar] > 1) {
                char leftChar = s.charAt(left);

                frequency[leftChar]--;
                left++;
            }

            // Update longest valid window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

// Approach 3 : Last Seen Index (Most Optimised Solution)
// TC - O(N)
// SC - O(1)
class Solution {

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int maxLength = 0;

        // lastSeen[ch] stores the last index
        // where character ch appeared
        int[] lastSeen = new int[128];

        Arrays.fill(lastSeen, -1);

        int left = 0;

        for (int right = 0; right < n; right++) {

            char currentChar = s.charAt(right);

            // If character was already seen inside
            // current window, move left pointer
            if (lastSeen[currentChar] >= left) {

                left = lastSeen[currentChar] + 1;
            }

            // Update last occurrence of current character
            lastSeen[currentChar] = right;

            // Update maximum window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
