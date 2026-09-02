class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        return solve(temperatures);
    }

    private static int[] solve(int[] temperatures) {
        var monotonic = new Stack<Integer>();
        var results = new int[temperatures.length];

        for (var i = 0; i < temperatures.length; i++) {
            var item = temperatures[i];

            while (!monotonic.isEmpty() && item > temperatures[monotonic.peek()]) {
                // If stack is not empty, and we have found a warmer day, compute the result
                var poppedIndex = monotonic.pop();
                results[poppedIndex] = i - poppedIndex;
            }

            monotonic.push(i);
        }

        return results;
    }
}
