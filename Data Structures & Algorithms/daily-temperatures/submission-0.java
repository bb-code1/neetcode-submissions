class Solution {
    public int [] bruteForce(int [] arr){
        int n = arr.length;
        int [] result = new int [n];

        for(int i = 0; i <n; i++){
            int track=0;
            for(int j = i+1; j<n;j++){
                track++;
                if(arr[j] > arr[i]){
                   result[i] = track;
                   break; 
                }
            }
        }
        return result;
    }
    public int[] dailyTemperatures(int[] temperatures) {
        return bruteForce(temperatures);
    }
}
