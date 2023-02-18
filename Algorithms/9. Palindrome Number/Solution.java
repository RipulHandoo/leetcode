class Solution {
    public boolean isPalindrome(int x) {
        int copy = x;
        int rev = 0;
        int n = 0;
//       if the number is smaller than zero simply return false.
        if(x < 0) {
            return false;
        }
      
//       revrese the number to compare with x, if both are equal return true else return false
        while(copy != 0) {
            n = copy%10;
            rev = rev*10 + n;
            copy = copy/10;
        }
        if(rev == x) {
            return true;
        }
        else {
            return false;
        }
    }
}
