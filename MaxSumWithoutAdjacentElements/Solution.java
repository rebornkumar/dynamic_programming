public class Solution {
    int getMaxSum(int[][] A,int[] dp,int index,int N,int M) {
        //base
        if(index >= N) return 0;
        if(index+1 == N) {
            return Math.max(A[0][index],A[1][index]);
        }
        //memo
        if(dp[index] != -1)return dp[index];
        //recur
        int left = Math.max(A[0][index],A[1][index]) + getMaxSum(A,dp,index+2,N,M);
        int right = getMaxSum(A,dp,index+1,N,M);
        return dp[index] = Math.max(left,right);
    }
    public int adjacent(int[][] A) {
        
        int m = A.length;
        if(m <= 0)return 0;
        
        int n = A[0].length;
        if(n == 0)return 0;
        
        int[] dp = new int[n];
        for(int i = 0;i < n;i++) {
            dp[i] = -1;
        }
        int ans = getMaxSum(A,dp,0,n,m);
        return ans;
    }
}
