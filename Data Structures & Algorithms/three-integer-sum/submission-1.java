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

    private List<List<Integer>> hashMap3Sum(int[] nums){
        Arrays.sort(nums);
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;


        for(int num : nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }

        for(int i =0; i< n; i++){
            freqMap.put(nums[i], freqMap.get(nums[i])-1);
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i +1 ; j < n; j++){
                freqMap.put(nums[j] , freqMap.get(nums[j])-1);

                if(j > i+1 && (nums[j] == nums[j-1])){
                    continue;
                }
                int target = -(nums[i] + nums[j]);

                if(freqMap.getOrDefault(target, 0) > 0){
                    result.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for(int j = i+1 ; j< n; j++){
                freqMap.put(nums[j] , freqMap.get(nums[j]) + 1);
            }

        }

        return result;


    }
    public List<List<Integer>> threeSum(int[] nums) {
        return hashMap3Sum(nums);

        
    }
}
