class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }
        int maxStreak =0;

        for(int num :nums){
            int currStreak =0; 
            int currentNum = num;
            while(numSet.contains(currentNum)){
                currStreak++;
                currentNum++;

            }
            maxStreak = Math.max(maxStreak,currStreak);

        }

        return maxStreak;
    }
}
