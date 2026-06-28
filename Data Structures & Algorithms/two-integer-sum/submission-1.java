class Solution {
    public int[] twoSum(int[] nums, int target) {

        int [] result = new int [2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            hashMap.put(nums[i],i);
        }

        for(int i =0;i<nums.length ; i++){
            int diff = target- nums[i];
            if(hashMap.get(diff) != null && hashMap.get(diff) != i ){
                result[0] = i;
                result[1] = hashMap.get(diff);
                return result;
            }

        }

        return result;
        

       
       
        
    }
}
