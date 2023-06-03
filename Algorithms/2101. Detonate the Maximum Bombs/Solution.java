class Solution {

    public void dfs(boolean[] visited,List<List<Integer>> gr, int[] c,int i){
        visited[i] = true;

        c[0]++;

        for(int j : gr.get(i)){
            if(!visited[j]){
                dfs(visited,gr,c,j);
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
       

        List<List<Integer>> gr = new ArrayList<>(n);

        for(int i = 0; i<n;i++){
            gr.add(new ArrayList<>());
            for(int j = 0;j<n;j++){
                if(i != j){
                    long x1 = bombs[i][0];
                    long y1 = bombs[i][1];
                    long r1 = bombs[i][2];
                    long x = bombs[j][0];
                    long y = bombs[j][1];

                    long distanceSq = (x - x1) * (x - x1) + (y - y1) * (y - y1);

                    if(r1 * r1 >= distanceSq){
                        gr.get(i).add(j);
                    }
                }
            }
        }


        int ans = 0;
        for(int i = 0;i<n;i++){
            boolean visited[] = new boolean[n];

            int[] c = new int[1];

            dfs(visited,gr,c,i);

            ans = Math.max(ans,c[0]);
        }
        return ans;
    }
}
