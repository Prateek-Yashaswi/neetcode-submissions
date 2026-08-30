class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return solve(nums, k);
    }

    private static int[] solve(int[] nums, int k) {
        var freq = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        return freq.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
