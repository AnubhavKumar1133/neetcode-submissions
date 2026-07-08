class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i<s.length(); i++){
            int s1 = s.charAt(i) - 'a';
            freq1[s1]++;
            int s2 = t.charAt(i) - 'a';
            freq2[s2]++;
        }
        for(int i = 0; i<26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}
