class Solution {
    private int bruteForceSol(String s, int k ){
        int maxLen = 0;
        for(int i = 0 ; i< s.length(); i++){
            HashMap<Character,Integer> count = new HashMap<>();
            int maxFreq =0;
            for(int j = i ; j<s.length(); j++){
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j),0)+1);
                maxFreq = Math.max(maxFreq, count.get(s.charAt(j)));

                if((j-i+1) - maxFreq <= k){
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
    public int characterReplacement(String s, int k) {
        return bruteForceSol(s, k);
    }
}
