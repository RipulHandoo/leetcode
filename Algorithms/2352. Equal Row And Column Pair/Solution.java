class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;


        for(int i = 0;i<grid.length;i++){
            String str = "";
            for(int j = 0;j<grid[i].length;j++){
                String curr = Integer.toString(grid[i][j]);
                str =str + "#" + curr;
            }
            if(map.containsKey(str)){
                map.put(str,map.get(str) + 1);
            }else{
                map.put(str,1);
            }
        }

        for(int l = 0;l<grid[0].length;l++){
            String str1 = "";
            for(int k = 0;k<grid.length;k++){
                String curr = Integer.toString(grid[k][l]);
                str1 = str1 + "#" + curr;
            }
            if(map.containsKey(str1)){
                count += map.get(str1);
            }
        }
        return count;
    }
}
