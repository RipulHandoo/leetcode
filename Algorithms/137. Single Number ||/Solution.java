class Solution {
    public int singleNumber(int[] nums) {
        int k = 3;
        int[] bitCounts = new int[32];
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                bitCounts[i] += (nums[j] >> i) & 1;
            }
            ans |= (bitCounts[i] % k) << i;
        }

        return ans;
    }
}
