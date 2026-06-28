class Solution {
    private int bruteForceSol(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxFreq = Math.max(maxFreq, count.get(s.charAt(j)));

                if ((j - i + 1) - maxFreq <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    private int slidingWindowSol(String s, int k ){
        int n = s.length();
        int maxLen = 0;
        HashSet<Character> charSet = new HashSet<>();
        for(char c : s.toCharArray()){
            charSet.add(c);
        }
        for(char c : charSet){
            int count =0;
            int left =0;
            for(int right = 0; right < n ; right++){
                if(s.charAt(right)== c){
                    count ++;
                }

                while((right - left + 1) - count > k){
                    if(s.charAt(left)== c){
                        count --;
                    }
                    left++;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
    public int characterReplacement(String s, int k) {
        // return bruteForceSol(s, k);
        return slidingWindowSol(s, k);
    }
}
