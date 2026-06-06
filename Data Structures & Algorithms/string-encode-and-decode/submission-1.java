class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        int len = strs.size();
        for(int i = 0; i<len; i++){
            int l = strs.get(i).length();
            sb.append(l);
            sb.append("#");
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j+1, j+1+len);
            list.add(word);
            i = j+1+len;
        }
        return list;
    }
}
