class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[][] link = new int[101][101];
        int[] degree = new int[101];

        for(int[] road : roads){
            link[road[0]][road[1]] = 1;
            link[road[1]][road[0]] = 1;
            degree[road[0]]++;
            degree[road[1]]++;
        }

        int max = -1;


        for(int i = 0;i<100;i++){
            for(int j = 0;j<100;j++){
                if(i != j){
                    int val = degree[i] + degree[j];
                    if(link[i][j] == 1){
                        val--;
                    }
                    max = Math.max(max,val);
                }
            }
        }
        return max;
    }
}
