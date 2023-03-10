// there are various method's to solve this problem statement 
// 1st (Brute Force algorithm) here in this we will linear traverse the whole matrix and where we find 0 we will change it's whole row and column with -1, and at th ewnd we will again linear traverse the matrix and change matrix element which are -1 to 0 (### But here we first have to ask the interviwer what will be input of integer's in matrix according to that we have change the value's.. Let say value will be greater than 0 in that case we can replace the rows and columns with -1) (####### Time complexity = O((N*M) * O(N+M)) and space complxity = O(1) ######) 

// 2nd method (Better approach) here in this one we will make two additional matrix naming them row(size of rows in matrix) and col(size of columns in matrix) and we will traverse the matrix linear and if we incounter a matrix element with value 0 we will set that rows[i] and col[j] to 0, after completing the first linear traverse, we will again traverse the matrix linear and check if any of rows[i] || col[j] is = 0 we will set that element to zero(#### Time complexity = (O(N*M) + (N*M)) and space complexity = O(N + M)) 

// 3rd approach (Best Optimal solution) the code is given below:
// (##### Time COmplexity = O((N*M) + (N*M)) and space complexity = O(1))

class Solution {
    public void setZeroes(int[][] matrix) {
        int col = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0;i<rows;i++){
            if(matrix[i][0] == 0){
                col = 0;
            }
            for(int j = 1;j<cols;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i = rows-1;i>=0;i--){
            for(int j = cols-1;j>=1;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col == 0){
                    matrix[i][0] = 0;
                }
        }
    }
}
