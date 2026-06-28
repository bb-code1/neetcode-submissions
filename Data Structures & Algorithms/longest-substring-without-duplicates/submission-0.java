class Solution {
    private int bruteForceSolution(String s){
        int n = s.length();
        int result = 0;

        for(int i =0; i< n; i++){
            HashSet<Character> charSet = new HashSet<>();

            for(int j = i; j< n; j++){
                if(charSet.contains(s.charAt(j))){
                    break;
                }
                charSet.add(s.charAt(j));
            }
            result = Math.max(result, charSet.size());
            
        }
        return result;
        
    }
    public int lengthOfLongestSubstring(String s) {
        return bruteForceSolution(s);
        
    }
}
