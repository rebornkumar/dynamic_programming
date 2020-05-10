public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    int MAX = 1005;
    int MAX_COST = 1000000000;
    
    long [][] dp = new long[MAX][MAX];
    
    long getMinCostForFriend(final int[] dc,final int [] cost,int currentCapacity,int currentDishIndex) {
        //base
        if(currentCapacity == 0)return 0;
        if(currentDishIndex >= dc.length || currentCapacity < 0) return MAX_COST;
        if(dp[currentCapacity][currentDishIndex] != -1) return dp[currentCapacity][currentDishIndex];
        
        long minCost = MAX_COST;
        for(int count = 0;count <= currentCapacity/dc[currentDishIndex];count++) {
            long tmpCost = count*cost[currentDishIndex] + getMinCostForFriend(dc,cost,currentCapacity - count*dc[currentDishIndex],currentDishIndex+1);
            minCost = Math.min(minCost,tmpCost);
        }
        dp[currentCapacity][currentDishIndex] = minCost;
        return dp[currentCapacity][currentDishIndex];
    }
    public int solve(final int[] fc, final int[] dc, final int[] cost) {
        int n = fc.length;
        int m = dc.length;
        int MAX_FC = 0;
        for(int i = 0;i < n;i++) {
            MAX_FC = Math.max(MAX_FC,fc[i]);
        }
        for(int i = 0; i <= MAX_FC;i++) {
            for(int j = 0;j < m;j++) {
                dp[i][j] = -1;
            }
        }
        long totalCost = 0;
        for(int i = 0;i < n;i++) {
            totalCost += getMinCostForFriend(dc,cost,fc[i],0);
        }
        return (int)totalCost;
    }
}

NDigitNumbersWithDigitSumS