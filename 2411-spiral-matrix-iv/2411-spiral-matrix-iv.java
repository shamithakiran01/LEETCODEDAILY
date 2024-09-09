class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Create a matrix filled with -1 initially
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1; // Fill with -1
            }
        }

        // Initialize the boundaries of the matrix
        int topRow = 0, bottomRow = m - 1, leftColumn = 0, rightColumn = n - 1;

        while (head != null) {
            // Fill top row from left to right
            for (int col = leftColumn; col <= rightColumn && head != null; col++) {
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;  // Move the top row boundary down

            // Fill right column from top to bottom
            for (int row = topRow; row <= bottomRow && head != null; row++) {
                matrix[row][rightColumn] = head.val;
                head = head.next;
            }
            rightColumn--;  // Move the right column boundary left

            // Fill bottom row from right to left
            for (int col = rightColumn; col >= leftColumn && head != null; col--) {
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;  // Move the bottom row boundary up

            // Fill left column from bottom to top
            for (int row = bottomRow; row >= topRow && head != null; row--) {
                matrix[row][leftColumn] = head.val;
                head = head.next;
            }
            leftColumn++;  // Move the left column boundary right
        }

        return matrix;
    }
}
