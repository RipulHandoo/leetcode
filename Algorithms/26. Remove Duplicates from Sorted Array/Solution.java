// Brute force approach Time complexity = O(N) and space complexity O(N)

// class Solution {
//     public int removeDuplicates(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int num: nums){
//             if(set.add(num)){
//                 list.add(num);
//             }
//         }

//         int i = 0;
//         for(int num1 : list){
//             nums[i++] = num1;
//         }

//         return list.size();
//     }
// }

// better approach Time Complexity = O(N) and space Complexity = O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j = 1;j<nums.length;j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
