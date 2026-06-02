package Day01;

/* https://leetcode.com/problems/set-matrix-zeroes/

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
*/
//Approach 1
//TC - (m * n)
//SC - O(m + n)
class Solution {

    public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        // rowMarked[i] = 1 -> ith row should become zero
        int[] rowMarked = new int[rowCount];

        // colMarked[j] = 1 -> jth column should become zero
        int[] colMarked = new int[colCount];

        // Step 1:
        // Traverse matrix and mark rows + columns
        // wherever we find a 0
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (matrix[row][col] == 0) {
                    rowMarked[row] = 1;
                    colMarked[col] = 1;
                }
            }
        }

        // Step 2:
        // Convert all marked rows into 0
        for (int row = 0; row < rowCount; row++) {
            if (rowMarked[row] == 1) {
                for (int col = 0; col < colCount; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Step 3:
        // Convert all marked columns into 0
        for (int col = 0; col < colCount; col++) {
            if (colMarked[col] == 1) {
                for (int row = 0; row < rowCount; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
