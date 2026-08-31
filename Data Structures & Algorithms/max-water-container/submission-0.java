class Solution {
    public int maxArea(int[] heights) {
        return solve(heights);
    }

    private static int solve(int[] heights) {
        var start = 0;
        var end = heights.length - 1;
        var area = 0;

        while (start < end) {
            var length = Math.abs(end - start);
            var breadth = Math.min(heights[start], heights[end]);
            area = Math.max(area, length * breadth);

            if (heights[start] <= heights[end]) start++;
            else end--;
        }

        return area;
    }
}
