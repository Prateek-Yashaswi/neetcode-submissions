class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return solve(piles, h);
    }

    private static int solve(int[] piles, int h) {
        var left = 1;
        int right = Arrays.stream(piles).boxed().max(Comparator.naturalOrder()).orElseThrow();

        while (left <= right) {
            var k = left + (right - left) / 2;
            var hoursNeeded = 0;

            for (var item : piles) {
                hoursNeeded += (item + k - 1) / k; // (int) Math.ceil((double) item / k)
            }

            if (hoursNeeded <= h) {
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return left;
    }
}
