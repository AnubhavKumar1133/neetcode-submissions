class Solution {
    public static int ans;
    public int recursion(int m, int n, int i, int j, int[][] dp){
        if(i < 0 || i>=m || j<0 || j>=n){
            return 0;
        }
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = recursion(m, n, i+1, j, dp);
        int right = recursion(m, n, i, j+1, dp);
        return dp[i][j] = down + right;
    }
    public int uniquePaths(int m, int n) {
        ans = 0;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        return recursion(m, n, 0, 0, dp);
    }
}
