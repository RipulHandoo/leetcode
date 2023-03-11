// brute force use two loops inner for loop and outer for loop check for each element if it is present in the array (#####Time comlexity O(N*N) space complexity =O(1)######)
// better solution make an array of size n and make initaly all the elements as 0,than iterate through given array and make all the index 1 that are present in the given array(##### Time Complexity= O(N) and space complexity = O(n))

// optimal solution 
// 1st use the formula of sum1 = N(N+1)/2  and sum2 is the sum of all the elements present in the array return sum1 - sum2 (#####Time complexity = O(N) and space complexity = O(1))

// 2nd Use XOR (i.e BIT MANIPULATION) here code is given below:
// (#######Time complexity = O(N) and space complexity = O(1))
class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = nums[0];
        for(int i = 1;i<nums.length;i++){
            xor1 ^= nums[i];
        }
        int xor2 = 0;
        for(int i = 1;i<=nums.length;i++){
            xor2 ^= i;
        }

        return xor2^xor1;
    }
}
