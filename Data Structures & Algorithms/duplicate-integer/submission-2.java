class Solution {
    public boolean hasDuplicate(int[] nums) {
       return solve(nums);
    }
    
    public static boolean solve(int[] nums) {
        var s = new HashSet<Integer>();

        for (var item : nums) {
            if (!s.add(item)) return true;
        }

        return false;
    }
}