class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;

         mergeSort(arr,0,n-1);
//        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for(int i = 1;i<n-1;i++){
            if(arr[i+1] - arr[i] != diff){
                return false;
            }
        }
        return true;
    }

    public void mergeSort(int[] arr,int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + (high - low)/2);

        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    public void merge(int[] arr, int low, int mid, int high){
        int[] result = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while(mid >= i && high >= j){
            if(arr[i] >= arr[j]){
                result[k] = arr[j];
                j++;
                k++;
            }
            else if(arr[j] > arr[i]){
                result[k++] = arr[i++];
            }
        }
        while(mid >= i){
            result[k++] = arr[i++];
        }
        while(high >= j){
            result[k++] = arr[j++];
        }

        for(int q = 0,l = low;q<result.length;q++,l++){
            arr[l] = result[q];
        }
    }
}
