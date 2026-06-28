class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] result = new int [n];

        for(int i =0; i<n;i++){
            int prod = 1;
            for(int j =0; j<n;j++){
                if(i != j){
                    prod= prod * nums[j];

                }
            }
            result[i] = prod;
        }
        return result;
        
    }
}  
