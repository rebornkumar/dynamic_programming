public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int[] best = new int[n];
        for(int i = 0;i < n;i++) {
            best[i] = Integer.MAX_VALUE;
        }
        best[0] = a.get(0).get(0);
        for(int i = 1;i < n;i++) {
            for(int j = 0;j <= i;j++) {
                int cellValue = a.get(i).get(j);
                if(j == 0) {
                    a.get(i).set(j,Math.min(cellValue + best[j],best[n-1]));
                }
                else if( j == i) {
                    a.get(i).set(j,Math.min(cellValue + best[j-1],best[n-1]));
                }
                else {
                    a.get(i).set(j,cellValue + Math.min(best[j-1],best[j]));
                }
            }
            for(int j = 0;j <= i;j++) {
                best[j] = a.get(i).get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++) {
            ans = Math.min(ans,a.get(n-1).get(i));
        }
        return ans;
    }
}
