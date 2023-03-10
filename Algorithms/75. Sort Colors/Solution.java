// this can be solved using 2-3 methods
// 1st sorting the array but it's time complexity will be O(nlon(n))
// 2nd will be doing the counting sorting in which just count the number of occurance's of 0,1,2 and then make another loop and keep adding them into the array'

// 3rd which is known as th eDutch National Flag algorithm in which we use three pointer's
// this algorithm can be extend in case where there are more number like(0,1,2,3) here pointer;s will be low, mid1, mid2, high
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length -1;
        while(high >= mid){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}
