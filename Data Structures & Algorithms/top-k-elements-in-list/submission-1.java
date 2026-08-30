class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return solve(nums, k);
    }

    private static int[] solve(int[] nums, int k) {
        var freq = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        return freq.entrySet().stream() // Traverse the freq map
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort based on values
                .limit(k) // Limit k items
                .mapToInt(Map.Entry::getKey) // For each item, get key
                .toArray(); // Collect keys into array and return
    }
}
