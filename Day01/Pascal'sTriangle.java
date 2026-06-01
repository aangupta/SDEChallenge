/*
https://leetcode.com/problems/pascals-triangle/description/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
*/

/* Quick Recall
First & last element -> 1
Middle element:
current = upperLeft + upper
*/
class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Generate each row one by one
        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();

            // Every row has (row + 1) elements
            for (int col = 0; col <= row; col++) {
                // First and last element are always 1
                if (col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    // Middle elements:
                    // value = upper-left + upper
                    int upperLeft = triangle.get(row - 1).get(col - 1);
                    int upper = triangle.get(row - 1).get(col);

                    currentRow.add(upperLeft + upper);
                }
            }

            // Add completed row into final triangle
            triangle.add(currentRow);
        }

        return triangle;
    }
}
