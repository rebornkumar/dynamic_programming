public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    int getMaxProduct(final int[] A,int start,int end) {
        int maxProduct = 1;
        int ans = Integer.MIN_VALUE;
        for(int i = start;i <= end;i++) {
            maxProduct *= A[i];
            ans = Math.max(ans,maxProduct);
        }
        maxProduct = 1;
         for(int i = end;i >= start;i--) {
            maxProduct *= A[i];
            ans = Math.max(ans,maxProduct);
        }
        return ans;
    }
    public int maxProduct(final int[] A) {
        int n = A.length;
        int ans = Integer.MIN_VALUE;
        int start = 0;
        for(int i = 0;i < n;i++) {
            if(A[i] == 0) {
                ans = Math.max(ans,getMaxProduct(A,start,i-1));
                ans = Math.max(0,ans);
                start = i+1;
            }
            else if(i + 1 == n) {
                ans = Math.max(ans,getMaxProduct(A,start,i));
            }
        }
        return ans;
    }
}
