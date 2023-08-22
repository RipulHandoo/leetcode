class Solution {
    public String convertToTitle(int n) {
        if(n <= 26){
            return Character.toString((char) 'A' + (n - 1)%26);
        }
        StringBuilder str = new StringBuilder();
        while(n > 0){
            if(n%26 == 0){
                str.append((char) ('A' +  25));
                n -= 1;
            }else{
                str.append((char) ('A' + n % 26 - 1));
            }
            n /= 26;
        }
        return str.reverse().toString();
    }
}
