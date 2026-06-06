class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for(int key : map.keySet()){
            list.add(new int[]{key, map.get(key)});
        }
        int full = list.size();
        int ch = full - k;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int i = 0; i<full; i++){
            pq.offer(list.get(i));
        }
        int[] ans = new int[k];
        for(int i = 0; i<ch; i++){
            pq.poll();
        }
        int idx = 0;
        while(!pq.isEmpty()){
            ans[idx] = pq.poll()[0];
            idx++;
        }
        return ans;
    }
}
