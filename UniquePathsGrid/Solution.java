public class Solution {
    
    public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        if(A[0][0] == 1)return 0;
        int[][] matrix = new int[n][m];
        matrix[0][0] = 1;
        for(int i = 1;i < m;i++) {
            matrix[0][i] = (A[0][i] == 0 && matrix[0][i-1] != 0) ? 1:0;
        }
        for(int i = 1;i < n;i++) {
            matrix[i][0] = (A[i][0] == 0 && matrix[i-1][0] != 0) ? 1:0;
        }
        for(int i = 1;i < n;i++) {
            for(int j = 1;j < m;j++) {
                if(A[i][j] == 0) {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                }
            }
        }
        return matrix[n-1][m-1];
    }
}
