class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] window = new int[n - k + 1];

        // if the size of required window is greater than the size of the array return empty window
        if(k > n)   return window;

        // Make a Deque that stores the index which will be used to maintain the maximum
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<k;i++){
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        // Make the sliding window and maintain the maximum
        int windowIdx = 0;
        for(int i = k;i<n;i++){
            window[windowIdx++] = nums[deque.peekFirst()];

            while(!deque.isEmpty() && deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        window[windowIdx] = nums[deque.peekFirst()];
        return window;
    }
}
