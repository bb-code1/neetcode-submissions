class Solution {
    public int maxArea(int[] heights) {
        
        int result =0;
        int n = heights.length;
        for(int i =0; i< n ;i++){
            for(int j = i+1; j< n; j++){
               result = Math.max(Math.min(heights[i], heights[j])  * (j-i),result);
            }
        }
        return result;
    }
}
