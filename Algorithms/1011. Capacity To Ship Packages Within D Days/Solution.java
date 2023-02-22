class Solution {
    boolean isPossible(int[] arr, int max, int days) {
        int count = 0;
        int d = 1;
        for(int i = 0;i<arr.length;i++) {
            if(count + arr[i] <= max) {
                count += arr[i];
            }
            else {
                d++;
                count = arr[i];
            }
        }
        if(d <= days) {
            return true;
        }
        else {
            return false;
        }
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i = 0;i<weights.length;i++) {
            low = Math.max(low,weights[i]);
            high += weights[i];
        }

        int ans = 0;
        while(high >= low) {
            int mid = high + (low - high)/2;

            if(isPossible(weights,mid,days)) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
}
