public class Solution {
    int mod = 1000007;
    int getTotalCount(int[][] dp,int[] coin,int index,int currentSum,int N) {
        //base
        if(currentSum == 0)return 1;
        if(index >= N || currentSum < 0)return 0;
        //memo
        if(dp[index][currentSum] != -1)return dp[index][currentSum];
        
        //recur
        int count = 0;
        for(int i = 0;i <= currentSum/coin[index];i++) {
            count += getTotalCount(dp,coin,index+1,currentSum - coin[index]*i,N);
            if(count >= mod) {
                count %= mod;
            }
        }
        return dp[index][currentSum] = count;
    }
    public int coinchange2(int[] A, int B) {
        
        int n = A.length;
        Arrays.sort(A);
        int[][] dp = new int[n][B+5];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j <= B;j++) {
                dp[i][j] = -1;
            }
        }
        int ans = getTotalCount(dp,A,0,B,n);
        return ans;
    }
}

