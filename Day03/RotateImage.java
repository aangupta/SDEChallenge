/* https://leetcode.com/problems/rotate-image/

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
*/

//TC - O(n ^ 2)
//SC - O(1)
class Solution {
    // Reverse a single row
    private void reverseRow(int[][] matrix, int row) {
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;

            left++;
            right--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1:
        // Transpose the matrix
        // Convert rows into columns
        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Step 2:
        // Reverse every row
        // to get 90 degree clockwise rotation
        for (int row = 0; row < n; row++) {
            reverseRow(matrix, row);
        }
    }
}
