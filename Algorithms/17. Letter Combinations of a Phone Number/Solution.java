import java.util.*;

class Solution {
    List<String> ans;
    String[] dial = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        StringBuilder str = new StringBuilder();
        helper(str, 0, digits);
        return ans;
    }
    
    private void helper(StringBuilder comb, int index, String digits) {
        if (index == digits.length()) {
            String curr = comb.toString();
            ans.add(curr);
            return;
        }
            
        String letters = dial[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            comb.append(letters.charAt(i));
            helper(comb,index + 1, digits);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
