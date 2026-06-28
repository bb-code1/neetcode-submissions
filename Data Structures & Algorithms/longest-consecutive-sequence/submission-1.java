class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet  = new HashSet<>();
        int maxStreak =0;

        for(int num : nums){
            numSet.add(num);
        }

        for(int num : nums){
            int currNum = num;
            int currStrek = 0;

            while(numSet.contains(currNum)){
                currStrek++;
                currNum++;
            }
            maxStreak = Math.max(maxStreak, currStrek);

        }

        return maxStreak;
        
    }
}
