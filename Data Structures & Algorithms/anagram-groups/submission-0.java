class Solution { 
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>> resultMap = new HashMap<>();

        for(String str: strs){
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            resultMap.putIfAbsent(sortedStr, new ArrayList<>());
            resultMap.get(sortedStr).add(str);

        }

        return new ArrayList<>(resultMap.values());
        
    }
}
