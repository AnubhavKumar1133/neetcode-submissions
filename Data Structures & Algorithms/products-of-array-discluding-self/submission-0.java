class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length-1] = 1;
        int[] answer = new int[nums.length];
        int l = nums.length;
        for(int i = 1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[l-i-1] = suffix[l-i] * nums[l-i];

        }
        for(int i = 0; i<l; i++){
            answer[i] = suffix[i]*prefix[i];
        }
        return answer;
    }
}  
