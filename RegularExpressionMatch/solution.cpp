bool wildCard(vector<vector<bool>>&dp,vector<vector<bool>>&done,const string A,const string B,int i,int j) {
        //base
        if(i >= A.size()) {
            for(int tmp = j;tmp < B.size();tmp++) {
                if(B[tmp] != '*') return false;
            }
            return true;
        }
        if(j >= B.size()) return false;
        //memo
        if(done[i][j] == true)return dp[i][j];
        //recur
        bool flag = false;
        if(A[i] == B[j] || B[j] == '?') {
            flag = flag || wildCard(dp,done,A,B,i+1,j+1);
        }
        else if(B[j] == '*'){
            for(int  k = i;k <= A.size();k++) {
                flag = flag || wildCard(dp,done,A,B,k,j+1);
            }
        }
        done[i][j] = true;
        return dp[i][j] = flag;
        
    }
int Solution::isMatch(const string A, const string B) {
        int n = A.size();
        int m = B.size();
        vector<vector<bool>>done(n+5,vector<bool>(m+5,false));
        vector<vector<bool>>dp(n+5,vector<bool>(m+5,false));
        return wildCard(dp,done,A,B,0,0) == true ? 1:0;
}
