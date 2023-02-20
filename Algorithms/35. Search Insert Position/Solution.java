// This is the simple binary algo in which if we get the target present in the array we'll return its index otherwise we'll travel the array by binary search algo and If the while loop completes without finding the target value, the method returns left, which represents the index where the target value should be inserted in the array to maintain its sorted order.

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        while(right >= left) {
            mid = right + (left - right)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] > target) {
                right = mid -1;
            }
            else {
                left = mid +1;
            }
        }
        return left;
    }
}
