public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        int n = A.length;
        if(n <= 1)return 0;
        int maxProfit = 0;
        int profit = A[0];
        for(int i = 1;i < n;i++) {
            if(A[i] > profit) {
                maxProfit = Math.max(A[i]-profit,maxProfit);
            }
            else {
                profit = A[i];
            }
        }
        return maxProfit;
    }
}