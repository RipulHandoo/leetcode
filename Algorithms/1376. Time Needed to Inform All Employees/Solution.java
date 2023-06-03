class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> gr = new ArrayList<>(n);
        for(int i = 0;i<n;i++){
            gr.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            int mng = manager[i];
            if(mng != -1){
                gr.get(mng).add(i);
            }
        }

        return calculateTime(gr,headID,informTime);
    }

    public int calculateTime(List<List<Integer>> gr, int currEmployee, int[] informTime){
        int maxTime = 0;
        for(int subordinate : gr.get(currEmployee)){
            maxTime = Math.max(maxTime, calculateTime(gr,subordinate,informTime));
        }
        return maxTime + informTime[currEmployee];
    }
}
