class Solution {
    boolean isValid(int n, int i, int j){
        if(i<0 || j<0 || i>=n || j>=n){
            return false;
        }
        return true;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        dist[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{dist[0][0], 0, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currcost = curr[0];
            int currrow = curr[1];
            int currcol = curr[2];
            for(int i = 0; i<4; i++){
                int newx = x[i] + currrow;
                int newy = y[i] + currcol;
                if(isValid(n, newx, newy)){
                    int newcost = Math.max(currcost, grid[newx][newy]);
                    if(dist[newx][newy] > newcost){
                        dist[newx][newy] = newcost;
                        pq.add(new int[]{newcost, newx, newy});
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
}
