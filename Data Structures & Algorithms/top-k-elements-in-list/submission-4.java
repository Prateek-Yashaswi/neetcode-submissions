class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return solveUsingHeap(nums, k);
    }

    private static int[] solve(int[] nums, int k) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(item -> item, Collectors.counting())) // Create Freqmap
                .entrySet().stream() // Traverse the freq map
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort based on values
                .limit(k) // Limit k items
                .mapToInt(Map.Entry::getKey) // For each item, get key
                .toArray(); // Collect keys into array and return
    }

    private static int[] solveUsingHeap(int[] nums, int k) {
        var countMap = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(item -> item, Collectors.collectingAndThen(Collectors.counting(), Math::toIntExact)));

        var minHeap = new PriorityQueue<Integer>(Comparator.comparingInt(countMap::get));

        for (var item: countMap.entrySet()) {
            minHeap.add(item.getKey());

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }

    private static int[] solveUsingBucketSort(int[] nums, int k) {
        var countMap = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(item -> item, Collectors.collectingAndThen(Collectors.counting(), Math::toIntExact)));

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (var item : countMap.entrySet()) {
            var num = item.getKey();
            var freq = item.getValue();

            buckets.get(freq).add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (int num : buckets.get(i)) {
                result[index++] = num;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
