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
        int result = 0;
        int n = s.length();
        // create hashset for storing unique characters
        HashSet<Character> charSet = new HashSet<>();

        for(char c : s.toCharArray()){
            charSet.add(c);
        }

        // iterate over each unique character of the charset 

        for(char c : charSet){

            int currCount = 0; // it is to store curr count of the chars so far 
            int left = 0; // it is used to track the start of the string and to shrink the string if needed

            for(int right = 0; right < n ; right++){
                // check if char at the right possition is equal to the current char
                if(s.charAt(right)== c){
                    currCount++;
                }
                // check if the window is valid if not shrink it form left
                while((right - left +1 ) - currCount > k){
                    // if window is invalid , remove the current char form the string
                    if(s.charAt(left ) == c){
                        currCount--;
                    }
                    left++;
                }
                result = Math.max(result , right - left +1);
            }
            

        }
        return result;


        
    }
    public int characterReplacement(String s, int k) {
        // return bruteForceSol(s, k);
        return slidingWindowSol(s, k);
    }
}
