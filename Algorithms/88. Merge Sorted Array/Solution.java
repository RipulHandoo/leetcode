class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        int result[] = new int[m+n];
        while(m > idx1 && n > idx2) {
            if(nums2[idx2] >= nums1[idx1]) {
                result[idx++] = nums1[idx1++];
            }
            else {
                result[idx++] = nums2[idx2++];
            }
        }
        while(m > idx1) {
            result[idx++] = nums1[idx1++];
        }
        while(n > idx2) {
            result[idx++] = nums2[idx2++];
        }

        for(int i = 0;i<result.length;i++) {
            nums1[i] = result[i];
        }
    }
}
