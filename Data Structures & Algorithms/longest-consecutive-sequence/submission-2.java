class Solution {
    public int longestConsecutive(int[] nums) {
        return solve(nums);
    }

    private static int solve(int[] nums) {
        if (nums.length == 0) return 0;
        var set = new HashSet<Integer>();

        for (var item : nums) set.add(item);

        var res = 0;
        for (var item : set) {
            if (!set.contains(item - 1)) {

                var current = item;
                var length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                res = Math.max(res, length);
            }
        }

        return res;
    }
}
