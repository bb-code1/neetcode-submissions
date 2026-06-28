class Solution {
    private List<List<Integer>> bruteForce3Sum(int[] nums){
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        for(int i =0; i< nums.length ; i++){
            for(int j = i+1; j< nums.length; j++){
                for(int k = j+1; k< nums.length; k++){
                    if(nums[i] + nums[j] +  nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i],nums[j], nums[k]);
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
    public List<List<Integer>> threeSum(int[] nums) {
return bruteForce3Sum( nums);
        
    }
}
