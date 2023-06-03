// Best approach space complexity =O(1) & Time complexity = O(N)
class Solution {
    public int singleNumber(int[] nums) {
        int XOR = 0;
        for(int num : nums){
            XOR ^= num;
        }
        return XOR;
    }
}
