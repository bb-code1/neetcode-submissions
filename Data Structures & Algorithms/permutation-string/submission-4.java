class Solution {
    private boolean bruteForceSol(String smallStr , String largeStr){
        char [] smallStrArr = smallStr.toCharArray();
        Arrays.sort(smallStrArr);
        String sortedSmallStr = new String(smallStrArr); // abc 

        int n = largeStr.length();
        for(int i = 0 ; i< n ; i++){
            for(int j = i; j< n ; j++){
                String subStr = largeStr.substring(i, j+1);
                char [] subStrArr = subStr.toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubStr = new String(subStrArr);

                if(sortedSubStr.equals(sortedSmallStr)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean hashTableSol(String smallStr, String largeStr){
        Map<Character,Integer> smallStrCountMap = new HashMap<>();
        for(char c :smallStr.toCharArray() ){
            smallStrCountMap.put(c,smallStrCountMap.getOrDefault(c,0)+1 );
        }


        int n = largeStr.length();

        for(int i = 0; i<n;i++){
            Map<Character, Integer> currMapCount = new HashMap<>();
            for(int j = i; j< n;j++){
                char c = largeStr.charAt(j);
                currMapCount.put(c, currMapCount.getOrDefault(c,0)+1);

                if(smallStrCountMap.getOrDefault(c,0) < currMapCount.get(c) ){
                    break;
                }

                if(j - i + 1 == smallStr.length() ){
                    return true;
                }
            }
        }
        return false;
    }


     public boolean slidingWindowSol(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        // WHAT: Frequency arrays for s1 and current window
        // WHY: Faster than HashMap (constant size: 26 letters)
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // WHAT: Build frequency for s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        int left = 0;

        // WHAT: Expand window using right pointer
        for (int right = 0; right < s2.length(); right++) {

            // Add current char to window
            windowCount[s2.charAt(right) - 'a']++;

            // WHAT: Keep window size equal to s1 length
            if (right - left + 1 > s1.length()) {
                windowCount[s2.charAt(left) - 'a']--;
                left++;
            }

            // WHAT: Compare both frequency arrays
            // WHY: If equal → permutation found
            if (matches(s1Count, windowCount)) {
                return true;
            }
        }

        return false;
    }

    // Helper function to compare both arrays
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        return slidingWindowSol(s1,s2);
        // hashTableSol(s1, s2);
        // bruteForceSol(s1, s2);
        
    }
}
