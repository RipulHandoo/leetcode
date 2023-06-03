// Best Approach with the time complexity = O(log(n*m))

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int high = (row*col) - 1;

        if(row == 0){
            return false;
        }

        while(low <= high){
            int mid = (low + (high - low)/2);

            if(matrix[mid/col][mid % col] == target){
                return true;
            }

            if(matrix[mid/col][mid % col] < target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
}
