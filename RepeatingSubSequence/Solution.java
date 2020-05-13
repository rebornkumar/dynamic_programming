public class Solution {
    int MAX = 105;
    int[][] dp = new int[MAX][MAX];
    
    int utilLCS(String A,int i,int j) {
        //base
        if(i >= A.length() || j >= A.length())return 0;
        //memo
        if(dp[i][j] != -1)return dp[i][j];
        //recur
        int count = 0;
        if(i != j) {
            if(A.charAt(i) == A.charAt(j)) {
                count = 1 + utilLCS(A,i+1,j+1);
            }
            else {
                count = Math.max(utilLCS(A,i+1,j),utilLCS(A,i,j+1));
            }
        }
        else {
            count = Math.max(utilLCS(A,i+1,j),utilLCS(A,i,j+1));
        }
        return dp[i][j] = count;
    }
    public int anytwo(String A) {
        
        int n = A.length();
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                dp[i][j] = -1;
            }
        }
        int ans = utilLCS(A,0,0);
        if(ans >= 2) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
