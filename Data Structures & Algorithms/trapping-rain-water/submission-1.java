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
    public int trap(int[] height) {
        return bruteForceSolution(height);

    } 
}
