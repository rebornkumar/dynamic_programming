public class Solution {
    public int canJump(int[] A) {
        int maxJump = 0, n = A.length;
        for(int i = 0;i < n;i++) {
            if(maxJump >= i) {
                maxJump = Math.max(maxJump,i+A[i]);
            }
        }
        if(maxJump >= n-1)return 1;
        else return 0;
    }
}
