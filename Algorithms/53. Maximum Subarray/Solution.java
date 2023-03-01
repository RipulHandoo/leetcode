// this problem is solved by using kadane's algorithm,
// which is used to find the maximum subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++) {
            max_so_far += nums[i];
            if(max_so_far > max){
                max = max_so_far;
            }
            if(max_so_far < 0) {
                max_so_far = 0;
            }
        }
        return max;
    }
}
