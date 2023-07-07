class Solution {
    public int helper(String answerKey, int k , char c){
        int n = answerKey.length();
        int begin = 0;
        int ans = 0;
        int count = 0;
        int last = 0;
        int first = 0;
        int[] rec = new int[n];

        for(int i = 0;i<n;i++){
            char curr = answerKey.charAt(i);

            if(curr != c){
                if(k == count){
                    begin = rec[first++] + 1;
                    rec[last++] = i;
                }
                else{
                    rec[last++] = i;
                    count++;
                }
            }
            ans = Math.max(ans,i - begin + 1);
        }
        return ans;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxT = helper(answerKey,k,'T');
        int maxF = helper(answerKey,k,'F');

        return Math.max(maxT, maxF);
    }
}
