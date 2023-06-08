class Solution {
    public int countNegatives(int[][] grid) {
        int row = 0;
        int col = grid[0].length - 1;
        int rows = grid.length;
        int count = 0;

        while(rows > row && col >= 0){
            if(grid[row][col] < 0){
                count += rows - row;
                col -= 1;
            }
            else{
                row += 1;
            }
        }
        return count;
    }
}
