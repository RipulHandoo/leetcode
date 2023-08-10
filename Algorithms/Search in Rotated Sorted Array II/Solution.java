// Brute force approach will be do a linear traverse and serach for the particular target if that target is present return true else return false (####### Time complexity = O(N) and space complexity = O(1))

// Optimal solution is do a binary serach in on the given array (##### Time complexity = O(log(N)) and space complexity = O(1))

class Solution {
    public boolean search(int[] nums, int target) {
         int n = nums.length;
         int left = 0;
         int right = n - 1;
         while(right >= left){
             int mid = (left + right)/2;

             if(nums[mid] == target){
                 return true;
             }
            //  If the array is of like this [3,1,2,3,3,3,3] in this case we cna not be able to find which side is sorted left or right
             if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                 left++;
                 right--;
                 continue;
             }
            //  /Search in the left sorted array
             else if(nums[mid] >= nums[left]){
                 if(nums[left] <= target && nums[mid] > target){
                     right = mid - 1;
                 }else{
                     left = mid + 1;
                 }
             }
            //  Search in the right sorted array
             else{
                 if(nums[mid] < target &&  nums[right] >= target){
                     left = mid + 1;
                 }else{
                     right = mid - 1;
                 }
            }
        }
        return false;
    }
}
