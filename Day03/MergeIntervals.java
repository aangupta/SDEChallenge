/*

https://leetcode.com/problems/merge-intervals/description/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.

*/

//TC - O(n logn)
//SC - O(n)
class Solution {

    public int[][] merge(int[][] intervals) {
        // If only one interval exists,
        // nothing to merge
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on start time
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        // Start with first interval
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];

        // Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            // Overlapping interval
            if (nextStart <= currentEnd) {
                // Extend merged interval
                currentEnd = Math.max(currentEnd, nextEnd);
            }
            // Non-overlapping interval
            else {
                // Store completed merged interval
                mergedIntervals.add(new int[] { currentStart, currentEnd });

                // Start new interval
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        // Add final interval
        mergedIntervals.add(new int[] { currentStart, currentEnd });

        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}
