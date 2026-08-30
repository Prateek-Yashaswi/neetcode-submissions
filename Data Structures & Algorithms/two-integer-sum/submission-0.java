class Solution {
    public int[] twoSum(int[] nums, int target) {
        return solve(nums, target);
    }

    private static int[] solve(int[] nums, int target) {
        var compliments = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            var compliment = target - nums[i];
            if (compliments.containsKey(nums[i])) {
                return new int[]{compliments.get(nums[i]), i};
            }

            compliments.put(compliment, i);
        }

        return new int[]{-1, -1};
    }
}
