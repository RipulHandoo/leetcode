class Solution {
    boolean check(int[] time, int tt, long max) {
        long count = 0;
        for(int i = 0;i<time.length;i++) {
            count += max/time[i];
        }
        return count >= tt;
    }
    public long minimumTime(int[] time, int totalTrips) {
       long l = 0;
       long min = 0;
       for(int i = 0;i<time.length;i++) {
           l = Math.min(l,time[i]);
           min = Math.max(min,time[i]);
       }
       long h = totalTrips*min;
        while(h > l) {
            long mid = l + (h-l)/2;

            if(check(time,totalTrips,mid)) {
                h = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
