public class SolutionMatrix {
    int mod = 1000007;
    
    public int coinchange2(int[] A, int B) {
        int n = A.length;
        int[] dp = new int[B+1];
        dp[0] = 1;
        for(int i = 0;i < n;i++) {
            for(int sum = 0;sum <= B;sum++) {
                int targetSum = A[i]+sum;
                if(dp[sum] != 0 && targetSum <= B) {
                    dp[targetSum] += dp[sum];
                    if(dp[targetSum] >= mod) {
                        dp[targetSum] %= mod;
                    }
                }
            }
        }
        return dp[B];
    }
}
