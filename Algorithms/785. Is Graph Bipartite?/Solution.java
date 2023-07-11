class Solution {
    public boolean check(ArrayList<ArrayList<Integer>> list, int[] color, int start){
        color[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbor : list.get(node)){
                if(color[neighbor] == -1){
                    color[neighbor] = 1 - color[node];
                    q.offer(neighbor);
                }
                else if(color[neighbor] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<graph[i].length;j++){
                list.get(i).add(graph[i][j]);
            }
        }

        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(check(list,color,i) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
