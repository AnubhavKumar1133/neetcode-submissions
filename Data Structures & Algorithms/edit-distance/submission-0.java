class Solution {
    public int recursion(String w1, String w2, int i, int j, int[][] dp) {
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if (i == w1.length()) {
            return w2.length() - j;
        }
        if (j == w2.length()) {
            return w1.length() - i;
        }
        if (w1.charAt(i) == w2.charAt(j)) {
            return recursion(w1, w2, i + 1, j + 1, dp);
        }
        int insert = recursion(w1, w2, i, j + 1, dp);
        int delete = recursion(w1, w2, i + 1, j, dp);
        int replace = recursion(w1, w2, i + 1, j + 1, dp);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return recursion(word1, word2, 0, 0, dp);
    }
}