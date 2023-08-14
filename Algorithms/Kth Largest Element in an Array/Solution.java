//Brute force approach to solve this question will be apply sorting and simply find the index TC(O(nlogn))
// Better approach will be using the heap TC = O(n) SC = O(n)
// optimal soultion is using quick select TC = O(n) && SC = O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums,n-k+1,0,n-1);
    }
    public int quickSelect(int[] nums, int k, int left, int right){
        if(left <= right){
            int pivot = partition(nums,left,right);
            if(pivot == k-1){
                return nums[pivot];
            }
            if(pivot < k-1){
               return quickSelect(nums,k,pivot +1 , right);
            }else{
                return quickSelect(nums,k,left,pivot-1);
            }
        }
        return Integer.MIN_VALUE;
    }
    public int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int j = left;

        for(int i = left;i < right;i++){
            if(pivot > nums[i]){
                int temp  = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        int temp = nums[right];
        nums[right] = nums[j];
        nums[j] = temp;
        return j;
    }
}
