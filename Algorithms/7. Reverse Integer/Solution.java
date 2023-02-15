class Solution {
    public int reverse(int x) {
        int copy = x;
        long rev = 0;
        int n = 0;
        while(copy != 0) {
            n = copy%10;
            rev = rev*10 + n;
            copy = copy/10;
        }
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        if(copy < 0) {
            rev = -rev;
            return (int)rev;
        }
        return (int)rev;
    }
}
