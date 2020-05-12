
vector<int>dp;
int getMaxSum(vector<vector<int>>&A,int index,int N) {
    //base
    if(index+1 == N)return max(A[0][index],A[1][index]);
    if(index >= N)return 0;
    //memo
    if(dp[index] != -1)return dp[index];
    //recur
    int left = max(A[0][index],A[1][index]) + getMaxSum(A,index+2,N);
    int right = getMaxSum(A,index+1,N);
    return dp[index] = max(left,right);
    // return max(left,right);
}
int Solution::adjacent(vector<vector<int> > &A) {
    int n = A.size();
    if(n == 0)return 0;
    int m = A[0].size();
    dp.clear();
    dp.resize(m,-1);
    int ans = getMaxSum(A,0,m);
    return ans;
}
