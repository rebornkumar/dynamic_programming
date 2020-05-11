public class Solution {
    int getCoinSum(int[][] dp,int[] coin,int start,int end) {
        //base
        if(start >= end) return 0;
        if(start+1 == end) {
            return Math.max(coin[start],coin[end]);
        }
        //memo
        if(dp[start][end] != -1)return dp[start][end];
        
        //recur
        int left = coin[start] + Math.min(getCoinSum(dp,coin,start+2,end),getCoinSum(dp,coin,start+1,end-1));
        int right = coin[end] + Math.min(getCoinSum(dp,coin,start+1,end-1),getCoinSum(dp,coin,start,end-2));
        return dp[start][end] = Math.max(left,right);
    }
    public int maxcoin(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                dp[i][j] = -1;
            }
        }
        int ans = getCoinSum(dp,A,0,n-1);
        return ans;
    }
}
