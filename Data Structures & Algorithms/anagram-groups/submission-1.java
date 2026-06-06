class Solution {
    public String createHash(String s){
        StringBuilder sb = new StringBuilder();
        char[] chaar = s.toCharArray();
        Arrays.sort(chaar);
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : chaar){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(char key : map.keySet()){
            sb.append(key);
            sb.append(map.get(key));
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            if(map.containsKey(createHash(strs[i]))){
                map.get(createHash(strs[i])).add(strs[i]);
            }
            else{
                ArrayList list = new ArrayList<>();
                list.add(strs[i]);
                map.put(createHash(strs[i]), list);
            }
        }
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;

    }
}
