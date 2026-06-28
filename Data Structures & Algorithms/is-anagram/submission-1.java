class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if(len1 != len2){
            return false;
        }

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        for(int i = 0; i<len1 ; i++){
            hashMap1.put(s.charAt(i),hashMap1.getOrDefault(s.charAt(i),0)+1 );
        }

        for(int i = 0; i<len2 ; i++){
            hashMap2.put(t.charAt(i),hashMap2.getOrDefault(t.charAt(i),0)+1 );
        }

        for(char ch : hashMap1.keySet()){
            if(!(hashMap1.get(ch).equals( hashMap2.get(ch)))){
                return false;
            }
        }

        return true;

        
        
        

    }
}
