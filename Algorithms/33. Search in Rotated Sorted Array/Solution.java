// Brute force approach to solve this problem statement would be traverse the whole array and search for particular number and simply return it's index (##### Time complexity = O(N) and space complexity = O(1)

// Optimal approach is given below with (###### Time complexity = O(log(n)) and space complexity = O(1))
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + (right - left)/2);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
