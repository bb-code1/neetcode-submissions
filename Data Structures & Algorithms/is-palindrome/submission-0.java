class Solution {
    private boolean isAlphaNumeric(Character c){
        return (
            c >= 'A' && c <='Z' ||
            c >= 'a' && c <= 'z' ||
            c >= '0' && c<='9'
        );
    }
    public boolean isPalindrome(String s) {
        int start =0;
        int end = s.length()-1;
        while(start < end){
            while(start < end && !isAlphaNumeric(s.charAt(start))){
                start++;
            }
            while(start < end && !isAlphaNumeric(s.charAt(end))){
                end--;
            }

            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))  ){
                return false;
            }
            start++;
            end--;
        }
        return true;
        
    }
}