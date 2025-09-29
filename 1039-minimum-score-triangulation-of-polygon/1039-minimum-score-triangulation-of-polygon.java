class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        // memo[i][j] stores min score for polygon from i to j
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(values, 0, n - 1, memo);
    }

    private int dfs(int[] v, int i, int j, int[][] memo) {
        // If fewer than 3 vertices, no triangle
        if (j - i <= 1) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int score = dfs(v, i, k, memo) + v[i] * v[k] * v[j] + dfs(v, k, j, memo);
            ans = Math.min(ans, score);
        }
        memo[i][j] = ans;
        return ans;
    }
}