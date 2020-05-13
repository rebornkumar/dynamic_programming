public class Solution {
    public int calculateMinimumHP(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] energy = new int[N][M];
        energy[N-1][M-1] = A[N-1][M-1] >= 0 ? 1 : 1 + Math.abs(A[N-1][M-1]); 
        
        for(int i = N-1;i > 0;i--) {
            energy[i-1][M-1] = A[i-1][M-1] - energy[i][M-1] >= 0 ? 1 : Math.abs(A[i-1][M-1] - energy[i][M-1]);
        }
        for(int i = M-1;i > 0;i--) {
            energy[N-1][i-1] = A[N-1][i-1] - energy[N-1][i] >= 0 ? 1 : Math.abs(A[N-1][i-1] - energy[N-1][i]);
        }
        for(int i = N-2;i >= 0;i--) {
            for(int j = M-2;j >= 0;j--) {
                int right = energy[i][j+1];
                int down = energy[i+1][j];
                energy[i][j] =  A[i][j] - Math.min(down,right) >= 0 ? 1 : Math.abs(A[i][j] - Math.min(down,right));
            }
        }
        return energy[0][0];
    }
}
