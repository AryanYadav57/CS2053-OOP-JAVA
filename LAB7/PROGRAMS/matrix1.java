package lab07;

public class matrix1 {
     public static void main(String[] args) {
            int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

            int n = matrix.length;

            int diagonalSum = 0;
            int upperDiagonalSum = 0;
            int lowerDiagonalSum = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    } else if (i < j) {
                        upperDiagonalSum += matrix[i][j];
                    } else if (i > j) {
                        lowerDiagonalSum += matrix[i][j];
                    }
                }
            }

            System.out.println("Sum of diagonal elements: " + diagonalSum);
            System.out.println("Sum of upper diagonal elements: " + upperDiagonalSum);
            System.out.println("Sum of lower diagonal elements: " + lowerDiagonalSum);
        }
    }

