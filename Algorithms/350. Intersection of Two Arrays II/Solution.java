class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        HashMap<Integer,Integer> map = new HashMap<>();
        int k = 0;
        for(int num : nums1){
            if(!map.containsKey(num)){
                map.put(num,1);
            }
            else {
                map.put(num,map.get(num)+1);
            }
        }

        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                result[k++] = num;
                map.put(num,map.get(num) -1);
            }
        }

        return Arrays.copyOfRange(result, 0, k);
    }
}
