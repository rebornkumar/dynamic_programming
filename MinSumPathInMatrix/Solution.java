public class Solution {
    public int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] vis = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++) {
                vis[i][j] = A[i][j];
            }
        }
        for(int i = 1;i < m;i++) {
            vis[0][i] = vis[0][i-1] + A[0][i];
        }
        for(int i = 1;i < n;i++) {
            vis[i][0] = vis[i-1][0] + A[i][0];
        }
        for(int i = 1;i < n;i++) {
            for(int j = 1;j < m;j++) {
                vis[i][j] = A[i][j]+Math.min(vis[i][j-1],vis[i-1][j]);
            }
        }
        return vis[n-1][m-1];
    }
}