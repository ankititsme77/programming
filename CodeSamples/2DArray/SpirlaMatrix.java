/**
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 *
 * Example 2-
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();

        int rows = matrix.length;
        int columns = matrix[0].length;
        int leftColumn = 0;
        int rightColumn = columns - 1;
        int topRow = 0;
        int bottomRow = rows - 1;

        while (res.size() < rows * columns) {
            // Traverse left to right
            for (int col = leftColumn; col <= rightColumn; col++) {
                res.add(matrix[topRow][col]);
            }

            // Traverse top to bottom
            for (int row = topRow + 1; row <= bottomRow; row++) {
                res.add(matrix[row][rightColumn]);
            }

            // Traverse right to left
            if (topRow != bottomRow) {
                for (int col = rightColumn - 1; col >= leftColumn; col--) {
                    res.add(matrix[bottomRow][col]);
                }
            }

            // Traverse bottom to up
            if (leftColumn != rightColumn) {
                for (int row = bottomRow - 1; row > topRow; row--) {
                    res.add(matrix[row][leftColumn]);
                }
            }

            // Update boundaries
            leftColumn++;
            rightColumn--;
            topRow++;
            bottomRow--;
        }

        return res;
    }
}
