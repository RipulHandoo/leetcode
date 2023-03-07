class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 1;
        int i = 0;
        while (i < arr.length && k > 0) {
            if (arr[i] - l > 0) {
                k -= arr[i] - l;
                if (k <= 0) {
                    return arr[i] - (Math.abs(k) + 1);
                }
            }
            l = arr[i] + 1;
            i++;
        }
        return arr[arr.length - 1] + k;
    }
}
