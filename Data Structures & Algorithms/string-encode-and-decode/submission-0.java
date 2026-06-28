class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }

        StringBuilder resultString = new StringBuilder();
        List<Integer> stringSizes = new ArrayList<>();

        for(String str : strs ){
            stringSizes.add(str.length());
        }
        for(int size : stringSizes){
            resultString.append(size).append(',');
        }

        resultString.append('#');
        for(String str : strs){
            resultString.append(str);
        }
        return resultString.toString();

    

    }

    public List<String> decode(String str) {
        if(str.length() == 0){
            return new ArrayList<>();
        }
        List<String> resultString = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i =0;
        while(str.charAt(i) != '#'){
            StringBuilder curr = new StringBuilder();
            while(str.charAt(i) != ','){
                curr.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(curr.toString()));
            i++;
        }
        i++;

        for(int sz : sizes){
            resultString.add(str.substring(i, i+sz));
            i+= sz;
        }

        return resultString;

    }
}
