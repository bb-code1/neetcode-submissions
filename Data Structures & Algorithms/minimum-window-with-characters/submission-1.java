class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()){
            return "";
        }

        HashMap<Character,Integer> charCountOfTarget = new HashMap<>();
        HashMap<Character,Integer> charCountOfWindow = new HashMap<>();

        for(char c: t.toCharArray() ){
            charCountOfTarget.put(c, charCountOfTarget.getOrDefault(c,0)+1);
        }

        int charsMatched = 0;
        int charNeeded = charCountOfTarget.size();
        int resLen = Integer.MAX_VALUE;
        int left = 0;
        int [] windowStartEndArray = {-1,-1};

        for(int right = 0; right< s.length(); right++){
            char currChar = s.charAt(right);
            charCountOfWindow.put(currChar,charCountOfWindow.getOrDefault(currChar,0)+1);

            if(charCountOfTarget.containsKey(currChar) &&
            charCountOfWindow.get(currChar) == charCountOfTarget.get(currChar) ){
                charsMatched++;
            }

            while(charsMatched == charNeeded){
                if((right - left + 1 ) < resLen){
                    resLen = right - left + 1 ;
                    windowStartEndArray[0] = left;
                    windowStartEndArray[1] = right;
                }
                char leftChar = s.charAt(left);
                charCountOfWindow.put(leftChar,charCountOfWindow.get(leftChar)-1);

                if(charCountOfTarget.containsKey(leftChar) && 
                charCountOfWindow.get(leftChar) < charCountOfTarget.get(leftChar)                
                ){
                    charsMatched--;
                }
                left ++;
            }

        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(windowStartEndArray[0],windowStartEndArray[1]+1);
        
    }
}
