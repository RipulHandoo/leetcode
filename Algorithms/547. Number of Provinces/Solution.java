class Solution {

    public void dfsUtil(List<List<Integer>> gr, boolean[] visited, int currNode){
        visited[currNode] = true;

        for(int adjNode : gr.get(currNode)){
            if(!visited[adjNode]){
                dfsUtil(gr,visited,adjNode);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int nodes = isConnected.length;

        List<List<Integer>> gr = new ArrayList<>();

        for(int i = 0;i< nodes; i++){
            gr.add(new ArrayList<>());
            for(int j = 0;j<nodes;j++){
                if(i != j && isConnected[i][j] != 0){
                    gr.get(i).add(j);
                }
            }
        }

        boolean visited[] = new boolean[nodes];

        for(int k = 0;k<nodes;k++){
            if(!visited[k]){
                dfsUtil(gr,visited,k);
                count++;
            }
        }

        return count;
    }
}
