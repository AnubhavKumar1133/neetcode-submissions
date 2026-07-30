
class Solution {

    public boolean compare(String[] words, HashMap<Character, List<Character>> adj, HashMap<Character, Integer> indegree) {

        for (int j = 0; j < words.length - 1; j++) {
            String word1 = words[j];
            String word2 = words[j + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2))
                return false;

            int len = Math.min(word1.length(), word2.length());

            for (int i = 0; i < len; i++) {

                if (word1.charAt(i) != word2.charAt(i)) {

                    char u = word1.charAt(i);
                    char v = word2.charAt(i);

                    // Avoid duplicate edges
                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                        indegree.put(v, indegree.get(v) + 1);
                    }

                    break; 
                }
            }
        }

        return true;
    }

    public String foreignDictionary(String[] words) {

        HashMap<Character, List<Character>> adj = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();

        // Initialize graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        if (!compare(words, adj, indegree))
            return "";

        StringBuilder ans = new StringBuilder();
        Queue<Character> q = new LinkedList<>();

        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {

            char curr = q.poll();
            ans.append(curr);

            for (char neigh : adj.get(curr)) {

                indegree.put(neigh, indegree.get(neigh) - 1);

                if (indegree.get(neigh) == 0) {
                    q.offer(neigh);
                }
            }
        }

        if (ans.length() != indegree.size())
            return "";

        return ans.toString();
    }
}