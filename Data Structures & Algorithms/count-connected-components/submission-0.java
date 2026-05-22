class Solution {
    public void bfs(int currNode, HashSet<Integer> visited, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currNode);
        visited.add(currNode); // Mark as visited when adding to the queue

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> neigh = adjList.get(node); // Get neighbors
            
            for (int neighbor : neigh) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor); // Mark as visited here
                }
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Initialize adjacency list
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        int comp = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                bfs(i, visited, adjList);
                comp++;
            }
        }

        return comp;
    }
}
