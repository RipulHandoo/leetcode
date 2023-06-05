class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;

        if(n == 1 || n == 2){
            return true;
        }

        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        if(x1 - x0 == 0){
            for(int i = 2;i<n;i++){
                if(coordinates[i][0] != x0){
                    return false;
                }
            }
            return true;
        }

        int dx = x1 - x0;
        int dy = y1 - y0;

        for(int i = 2;i<n;i++){
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            if(dx * (y - y0) != dy * (x - x0)){
                return false;
            }
        }
        return true;
    }
}
