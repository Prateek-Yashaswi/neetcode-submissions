class Solution {
    public int[] productExceptSelf(int[] nums) {
        return solveWithoutDiv(nums);
    }

    private static int[] solveWithoutDiv(int[] nums) {
        var output = new int[nums.length];
        Arrays.fill(output, 1);

        for (var i = 1; i < nums.length; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }

        var suffix = 1;
        for (var i = nums.length - 1; i >= 0; i--) {
            output[i] = suffix * output[i];
            suffix = suffix * nums[i];
        }

        return output;
    }
}  
