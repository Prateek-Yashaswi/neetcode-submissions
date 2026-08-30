class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return solve(strs);
    }

    private static List<List<String>> solve(String[] strs) {
        var hashStore = new HashMap<String, List<String>>();

        for (var item : strs) {
            var hash = createHash(item);
            hashStore.computeIfAbsent(hash, k -> new ArrayList<>()).add(item);
        }

        return hashStore.values().stream().toList();
    }

    private static String createHash(String str) {
        var freq = new int[26];
        StringBuilder hash = new StringBuilder();

        for (var ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (var i = 0; i < 26; i++) {
            hash.append(freq[i]);
            hash.append("GOAT");
        }

        return hash.toString();
    }
}
