class Solution {
    public int singleNonDuplicate(int[] nums) {
       int n = nums.length;
       if(n==1) { return nums[0]; }
       if(nums[0] != nums[1]) { return nums[0]; }
       if(nums[n-1] != nums[n-2]) { return nums[n-1]; }

       int low = 0,high = n-1;
       while(low<=high){
           int mid = low+(high-low)/2;
           if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
               return nums[mid];
           }
           else if(nums[mid] == nums[mid-1]){
               int lc = mid-low+1;
               if(lc%2 == 0){
                   low = mid+1;
               }else{
                   high = mid-2;
               }
           }
           else if(nums[mid] == nums[mid+1]){
               int rc = high-mid+1;
               if(rc%2 == 0){
                   high = mid-1;
               }else{
                   low = mid+2;
               }
           }
       }
         return -1;
    }
}
