public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestSubsequenceLength(final int[] A) {
        
        int n = A.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for(int i = 0;i < n;i++) {
            dp1[i] = 1;
            dp2[i] = 1;
        }
        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(A[i] > A[j]) {
                    dp1[i] = Math.max(dp1[i],dp1[j]+1);
                }
                if(A[n-1-i] > A[n-1-j]) {
                    dp2[n-1-i] = Math.max(dp2[n-1-i],dp2[n-1-j]+1);
                }
            }
        }
        int ans = 0;
        for(int i = 0;i < n;i++) {
            ans = Math.max(dp1[i]+dp2[i]-1,ans);
        }
        return ans;
    }
}
