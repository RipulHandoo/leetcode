class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();


        for(int i = 0;i<nums.length;i++){
            String str = Integer.toString(nums[i]);
            String last = "";

            while(nums.length > i+1 && nums[i] + 1 == nums[i+1]){
                last = Integer.toString(nums[i+1]);
                i++;
            }
            if(last == ""){
                list.add(str);
            }
            else{
                str = str + "->" + last;
                list.add(str);
            }
        }
        return list;
    }
}
