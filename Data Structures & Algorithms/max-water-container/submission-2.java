class Solution {
    private int bruteForce(int[] heights){
        int result =0;
        int n = heights.length;
        for(int i =0; i< n ;i++){
            for(int j = i+1; j< n; j++){
               result = Math.max(Math.min(heights[i], heights[j])  * (j-i),result);
            }
        }
        return result;
    }

    private int twoPointerSolution(int [] heights){
        int n = heights.length;
        int left =0;
        int right = n-1;
        int result =0;


        while(left < right){
            int area = Math.min(heights[left], heights[right]) * (right - left);
            result = Math.max(result, area);

            if(heights[left] <= heights[right]){
                left ++;
            }else{
                right --;
            }
        }
        return result;


    }
    public int maxArea(int[] heights) {
        return twoPointerSolution(heights);
        
        
    }
}
