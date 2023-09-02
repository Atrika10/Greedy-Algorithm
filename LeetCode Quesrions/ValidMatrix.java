import java.util.*;
public class ValidMatrix {

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int matrix[][] = new int[rowSum.length][colSum.length];
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < rowSum.length && j < colSum.length) {
            min = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = min;
            rowSum[i] -= min;
            colSum[j] -= min;

            // anyone will be 0; whoever will be zero move that pointer by one
            if (rowSum[i] == 0) { // next row
                i++;
            }
            if (colSum[j] == 0) { // next column
                j++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int rowSum[] = { 14, 9 }, colSum[] = { 6, 9, 8 };
        int matrix[][] = restoreMatrix(rowSum, colSum);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
