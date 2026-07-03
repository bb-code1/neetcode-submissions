class Solution {
    private String bruteForceSol(String s, String t){
        if(t.isEmpty()){
            return "";
        }
        Map<Character,Integer> charMapT = new HashMap<>();

        for(char c : t.toCharArray()){
            charMapT.put(c, charMapT.getOrDefault(c,0)+ 1);
        }

        int [] result = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for(int i =0; i< s.length(); i++){
            Map<Character,Integer> charMapS = new HashMap<>();
            for(int j = i; j< s.length(); j++){
                charMapS.put(s.charAt(j),charMapS.getOrDefault(s.charAt(j),0)+1  );

                boolean flag = true;
                for( char c : charMapT.keySet() ){
                    if(charMapS.getOrDefault(c,0)< charMapT.get(c)){
                        flag = false;
                        break;
                    }
                }
                if(flag && (j- i + 1) < resLen){
                    resLen = j - i + 1;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
    public String minWindow(String s, String t) {
        return bruteForceSol(s,t);
        
    }
}
