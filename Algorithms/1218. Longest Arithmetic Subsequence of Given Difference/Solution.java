class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;

        for(int i =0;i<arr.length;i++){
            int tempAns = 0;
            int temp = arr[i] - difference;

            if(map.containsKey(temp)){
                tempAns = map.get(temp);
            }

            map.put(arr[i],tempAns + 1);

            ans = Math.max(ans,map.get(arr[i]));
        }

        return ans;
    }
}
