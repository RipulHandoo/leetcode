class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0;i<prerequisites.length;i++){
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int it : list.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();

        for(int i = 0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int neighbor : list.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        if(topo.size() == numCourses){
            return true;
        }
        return false;
    }
}
