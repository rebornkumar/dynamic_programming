public class Solution {
    public int[] solve(int A, int[] B) {
        
        int minElement = Integer.MAX_VALUE;
        int minIndex = -1;
        int n = B.length;
        for(int i = 0;i < n;i++) {
            if(minElement > B[i]) {
                minElement = B[i];
                minIndex = i;
            }
        }
        int maxLength = A/minElement;
        int remainingValue = A - (maxLength)*minElement;
        int [] ans = new int[maxLength];
        for(int i = 0;i < maxLength;i++) {
            ans[i] = minIndex;
        }
        int k = 0;
        for(int i = 0;i < minIndex && k < maxLength;i++) {
            if(B[i]-minElement <= remainingValue && k < maxLength) {
                ans[k++] = i;
                remainingValue -= (B[i]-minElement);
                i--;
            }
        }
        return ans;
    }
}
