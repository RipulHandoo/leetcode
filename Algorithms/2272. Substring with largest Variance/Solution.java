class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }

        for(char ch1 = 'a'; ch1 <= 'z'; ch1++){
            for(char ch2 = 'a'; ch2 <= 'z'; ch2++){
                if(ch1 == ch2 || map.get(ch1) == null || map.get(ch2) == null){ // if the characters are same than simply the vairance is zero and if the character is not present in the map then it is not in string
                    continue;
                }

                for(int rev = 1;rev <=2;rev++){ // as we have to check for the 2 different characters only
                    int cnt1 = 0;
                    int cnt2 = 0;
                    for(char c : s.toCharArray()){
                        if(c == ch1){
                            cnt1++;
                        }else if(c == ch2){
                            cnt2++;
                        }

                        if(cnt2 > cnt1){ // if cnt2 > cnt1 than the cnt1 - cnt2 < 0 but the max difference can be zero so we itself set it to 0
                            cnt1=0;
                            cnt2 = 0;
                        }
                        if(cnt1 > 0 && cnt2 >0){ // update the ans only if 2 characters are present
                            ans = Math.max(ans, cnt1 - cnt2);
                        }
                    }
                   s = new StringBuilder(s).reverse().toString(); // revrese the string and check again
                }
            }
        }
        return ans;
    }
}
