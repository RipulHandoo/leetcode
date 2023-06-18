class Solution {
    int mod = (int)(1e9+7);
    public int[][] dp = new int[1001][1001];
    public int solve(int[][] grid, int i, int j, int prev){
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i>= m || j < 0 || j >=n || grid[i][j] <= prev){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = solve(grid,i-1,j,grid[i][j]);
        int down = solve(grid,i+1,j,grid[i][j]);
        int left = solve(grid,i,j-1,grid[i][j]);
        int right = solve(grid,i,j+1,grid[i][j]);

        return dp[i][j] = (1 + up + down + left + right) % mod;
    }
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                ans = (ans + solve(grid,i,j,-1)) % mod;
            }
        }

        return ans;
    }
}
