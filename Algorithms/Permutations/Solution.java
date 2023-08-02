class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = new int[11];
        Arrays.fill(arr,11);
        permutation(nums,arr,result,0);
        return result;
    }
    public void permutation(int[] nums, int[] arr, List<List<Integer>> result, int currInd){
        if(currInd == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                list.add(arr[i]);
            }
            result.add(list);
            return;
        }
        else{
            for(int i = 0;i<nums.length;i++){
                if(arr[i] == 11){
                    arr[i] = nums[currInd];
                    permutation(nums,arr,result,currInd + 1);
                    arr[i] = 11;
                }
            }
        }
    }
}
