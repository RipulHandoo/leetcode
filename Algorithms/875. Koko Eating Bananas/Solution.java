class Solution {
    public boolean canEat(int[] piles, int h, int speed){
        int time = 0;
        for (int i = 0;i<piles.length;i++) {
            int pile = piles[i];
            time += (pile - 1) / speed + 1;
            if (time > h) {
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int i = 0;i<piles.length;i++) {
            right = Math.max(piles[i],right);
        }

        while(right > left) {
            int mid = (left+right)/2;

            if(canEat(piles,h,mid)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
