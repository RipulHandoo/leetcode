class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int max = -1;
        for(int num : nums){
            if(num == 1){
                sum++;
            }
            if(sum > max){
                max = sum;
            }
            else {
                sum = 0;
            }
        }
        return max;
    }
}
