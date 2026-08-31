class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return solve(nums);
    }

    private static List<List<Integer>> solve(int[] nums) {
        var output = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i++) {
            var first = nums[i];

            if (i - 1 >= 0 && first == nums[i - 1]) {
                continue;
            }

            var start = i + 1;
            var end = nums.length - 1;
            while (start < end) {
                var second = nums[start];
                var third = nums[end];
                var sum = first + second + third;
                if (sum == 0) {
                    output.add(List.of(first, second, third));
                    start++;
                    end--;

                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return output;
    }
}
