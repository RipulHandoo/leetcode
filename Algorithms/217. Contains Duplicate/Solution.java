class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        boolean flag = false;
        for(int i = 0;i<nums.length;i++) {
            if(set.contains(nums[i])) {
                flag = true;
                return flag;
            }
            else {
                set.add(nums[i]);
            }
        }
        return flag;
    }
}
