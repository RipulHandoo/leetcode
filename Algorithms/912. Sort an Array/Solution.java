class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0,nums.length-1);
        return nums;
    }
    
    public void quicksort(int[] nums, int low, int high){
        if(low<high){
          int pivot = nums[(low+high)/2];
          int index = partition(nums,low,high,pivot);
          quicksort(nums,low,index-1);
          quicksort(nums,index,high);
        }
    }
    
    public int partition(int[] nums, int low, int high, int pivot){
        while(low<=high){
            while(nums[low]<pivot)
                low++;
            while(nums[high]>pivot)
                high--;
            if(low<=high){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }
}
