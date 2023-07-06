// Brute force approach is like find all the sub-arays store them in a arrayList and then check for each sub-array is its sum is greater than or equal to target
// Its time complexity will be O(N^2) and space complexity will be O(N^2)


// optimal Approach
// Use the Sliding window Approach
// It has the time complexity of O(N) and space complexity of O(1)


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int n = nums.length;

        while(n > j){
            sum += nums[j];
            while(sum >= target){
                sum -= nums[i];
                ans = Math.min(ans,j-i+1);
                i++;
            }
            j++;
        }
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}

// The better solution is using the Two Pointers Approach
// Time complexity O(nlog(n)) and space complexity O(1)

// class Solution{
//     public int minSubArrayLen(int target, int[] nums){
//          int n = nums.length;
        // int minLen = Integer.MAX_VALUE;
        
        // for (int i = 0; i < n; i++) {
        //     int sum = 0;
            
        //     // Find the end index using two pointers
        //     int j = i;
        //     while (j < n && sum < target) {
        //         sum += nums[j];
        //         j++;
        //     }
            
        //     if (sum >= target) {
        //         minLen = Math.min(minLen, j - i);
        //     }
        // }
        
        // return (minLen != Integer.MAX_VALUE) ? minLen : 0;
//         }
//     }
// }
