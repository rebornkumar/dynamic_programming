public class Solution {
    int MAX = 705;
    int[][] dp = new int[MAX][MAX];
    
    int getDistinctCount(String A,String B,int i,int j) {
        if(j == B.length())return 1;
        if(i >= A.length())return 0;
        if(dp[i][j] != -1)return dp[i][j];
        
        int count = 0;
        if(A.charAt(i) == B.charAt(j)) {
            count = getDistinctCount(A,B,i+1,j)+getDistinctCount(A,B,i+1,j+1);
        }
        else {
            count = getDistinctCount(A,B,i+1,j);
        }
        return dp[i][j] = count;
    }
    public int numDistinct(String A, String B) {
        
        int n = A.length();
        int m = B.length();
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                dp[i][j] = -1;
            }
        }
        int ans = getDistinctCount(A,B,0,0);
        return ans;
    }
}
