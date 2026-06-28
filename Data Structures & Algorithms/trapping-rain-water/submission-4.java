class Solution {
    private int bruteForceSolution(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int n = height.length;
        int totalRainTrapped = 0;

        for(int i = 0; i<n ; i++){
            int maxLeftWallHeight =height[i];
            int maxRightWallHeight = height[i];

            for(int j = 0; j<i; j++){
                maxLeftWallHeight = Math.max(maxLeftWallHeight,height[j]);

            }

            for(int k = i+1; k<n ; k++){
                maxRightWallHeight = Math.max(maxRightWallHeight,height[k]);
            }

            totalRainTrapped = totalRainTrapped +Math.min(maxRightWallHeight,maxLeftWallHeight) - height[i];



        }
        return totalRainTrapped;
    }

    private int preFixSufixSolution(int[] height){
        int n = height.length;
        int [] leftMaxArr = new int [n];
        int [] rightMaxArr = new int [n];
        leftMaxArr[0] = height[0];
        rightMaxArr[n-1] = height[n-1];

        for(int i =1; i< n ; i++){
            leftMaxArr[i] = Math.max(leftMaxArr[i-1],height[i]);
        }

        for(int i = n-2 ; i>=0; i--){
            rightMaxArr[i] = Math.max(rightMaxArr[i+1],height[i]);
        }

        int totolRainTrapped =0;

        for(int i =0 ; i< n ; i++){
            totolRainTrapped = totolRainTrapped + Math.min(rightMaxArr[i],leftMaxArr[i])- height[i];
        }

        return totolRainTrapped;

    }
    public int trap(int[] height) {
        return preFixSufixSolution(height);
        // bruteForceSolution(height);

    } 
}
