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
    public boolean checkInclusion(String s1, String s2) {
        return bruteForceSol(s1, s2);
        
    }
}
