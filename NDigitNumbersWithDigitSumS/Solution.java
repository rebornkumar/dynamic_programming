public class Solution {
    long mod = 1000000007;
    
    int getNumberCount(int[][] dp,int N,int S) {
        //base
        if(N == 1) {
            if(S > 0 && S < 10)return 1;
            else return 0;
        }
        if(S <= 0)return 0;

        if(dp[N][S] != -1)return dp[N][S];
        int totalCount = 0;
        for(int i = 0;i < 10;i++) {
            if(S-i >= 0)
            totalCount += getNumberCount(dp,N-1,S-i);
            if(totalCount >= mod) {
                totalCount %= mod;
            }
        }
        return dp[N][S] = totalCount;
    }
    public int solve(int N, int S) {
        if(N == 0)return 0;
        int[][] dp = new int[N+1][S+1];
        for(int i = 0;i <= N;i++) {
            for(int j = 0;j <= S;j++)
            dp[i][j] = -1;
        }
        int ans = getNumberCount(dp,N,S);
        return ans;
    }
}
