class Solution{
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for(int i = 0;i<nums1.length && i < k ;i++){
            q.offer(new int[]{nums1[i],nums2[0],0});
        }

        while(k > 0 && !q.isEmpty()){
            int[] curr = q.poll();
            int num1 = curr[0];
            int num2 = curr[1];
            int index = curr[2];
            result.add(Arrays.asList(num1,num2));
            if(nums2.length - 1 > index){
                q.offer(new int[]{num1, nums2[index+1],index+1});
            } 
            k--;
        }
        return result;
    }
}
// this will give Memory limit exceeds as it generates all the possible sum that could occur with space and time complexity of O(n*m)


// public class Triplet implements Comparable<Triplet> {
//     public int firstNum;
//     public int secondNum;
//     public int sum;
    
//     Triplet(int first, int second, int sum) {
//         this.firstNum = first;
//         this.secondNum = second;
//         this.sum = sum;
//     }
    
//     @Override
//     public int compareTo(Triplet other) {
//         return Integer.compare(this.sum, other.sum);
//     }
// }

// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         PriorityQueue<Triplet> q = new PriorityQueue<>();

//         for(int i = 0;i<nums1.length;i++){
//             int num = nums1[i];
//             for(int j = 0;j < nums2.length;j++){
//                 int sum = num + nums2[j];
//                 q.offer(new Triplet(num,nums2[j],sum));
//             }
//         }
//         List<List<Integer>> result = new ArrayList<>();
//         while(k > 0 && !q.isEmpty()){
//             List<Integer> list = new ArrayList<>();
//             Triplet trip = q.poll();
//             list.add(trip.firstNum);
//             list.add(trip.secondNum);
//             result.add(list);
//             k--;
//         }

//         return result;
//     }
// }
