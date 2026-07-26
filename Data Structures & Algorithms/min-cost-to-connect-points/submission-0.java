
class Solution {

    int[] parent;

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if (rootx == rooty) {
            return;
        }

        parent[rootx] = rooty;
    }

    public int kruskal(List<int[]> edges) {

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int ans = 0;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (find(u) != find(v)) {
                ans += wt;
                union(u, v);
            }
        }

        return ans;
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int dist =
                        Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{i, j, dist});
            }
        }

        return kruskal(edges);
    }
}