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

        int smallStrMapSize = smallStrCountMap.size();

        int n = largeStr.length();

        for(int i = 0; i<n;i++){
            Map<Character, Integer> currMapCount = new HashMap<>();
            int curr = 0;
            for(int j = i; j< n;j++){
                char c = largeStr.charAt(j);
                currMapCount.put(c, currMapCount.getOrDefault(c,0)+1);

                if(smallStrCountMap.getOrDefault(c,0) < currMapCount.get(c) ){
                    break;
                }

                if(smallStrCountMap.getOrDefault(c,0) == currMapCount.get(c) ){
                    curr++;
                }

                if(j - i + 1 == smallStr.length() ){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkInclusion(String s1, String s2) {
        return hashTableSol(s1, s2);
        // bruteForceSol(s1, s2);
        
    }
}
