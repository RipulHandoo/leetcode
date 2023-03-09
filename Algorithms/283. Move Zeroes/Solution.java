class Solution {
    public void moveZeroes(int[] nums) {
        int count=0;
        int l = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0) {
                count++;
            }
            else {
                nums[l++] = nums[i];
            }
        }
        for(int i = 0;i<count;i++) {
            nums[l++] = 0;
        }
    }
}
