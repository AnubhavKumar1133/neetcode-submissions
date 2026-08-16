class Solution {

    public int recursion(int[] nums, int len, Map<String, Integer> map) {

        String key = Arrays.toString(nums);

        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (len == 1) {
            map.put(key, nums[0]);
            return nums[0];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {

            int curr;

            if (i == 0) {
                curr = nums[i] * nums[i + 1];
            }
            else if (i == len - 1) {
                curr = nums[i] * nums[i - 1];
            }
            else {
                curr = nums[i] * nums[i - 1] * nums[i + 1];
            }

            int[] newarr = new int[len - 1];

            int l = 0;

            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }

                newarr[l++] = nums[j];
            }

            max = Math.max(
                max,
                curr + recursion(newarr, len - 1, map)
            );
        }

        map.put(key, max);

        return max;
    }

    public int maxCoins(int[] nums) {
        Map<String, Integer> map = new HashMap<>();

        return recursion(nums, nums.length, map);
    }
}