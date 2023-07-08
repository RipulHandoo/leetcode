class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] prefixSum = new int[n-1];
        for(int i = 1;i<n;i++){
            prefixSum[i-1] = weights[i] + weights[i - 1];
        }

        Arrays.sort(prefixSum);
        long min = 0;
        long max = 0;

        for(int i = 0;i< k -1 ;i++){
            min += prefixSum[i];
            max += prefixSum[n-i-2];
        }

        return max - min;
    }
}
