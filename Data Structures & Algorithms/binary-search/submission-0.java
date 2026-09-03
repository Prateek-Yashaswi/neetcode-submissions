class Solution {
    public int search(int[] nums, int target) {
        return solve(nums, target);
    }

    private static int solve(int[] nums, int target) {
        var start = 0;
        var end = nums.length - 1;

        while (start <= end) {
            var mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
