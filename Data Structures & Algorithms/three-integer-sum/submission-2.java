class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return solve(nums);
    }

    private static List<List<Integer>> solve(int[] nums) {
        var output = new ArrayList<List<Integer>>();

        // Sort the array first
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i++) {
            var first = nums[i];

            // If the value is equal to the previous value, we dont need to reprocess it
            if (i - 1 >= 0 && first == nums[i - 1]) {
                continue;
            }

            // Run 2-Sum Algorithm
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

                    // Once we got our answer, and the item at start or end is already visited
                    // We dont need to reprocess it
                    while (start < end && nums[start] == nums[start - 1]) start++;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                } else if (sum > 0) {
                    // When sum is more, we have to reduce the number and since the array is sorted, 
                    // We can decrement end
                    end--;
                } else {
                    // When sum is less, we have to increase the number and since the array is sorted, 
                    // We can increment start
                    start++;
                }
            }
        }

        return output;
    }
}
