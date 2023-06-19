class Solution {
    public int largestAltitude(int[] gain){
        if(gain.length <= 0 && gain.length >= 101){
            return 0;
        }
        int gains = 0;
        int max = 0;
        for(int alt : gain){
            gains = gains + alt;
            max = Math.max(max, gains);
        }

        return max;
    }
}
