class Solution {
    public boolean isAnagram(String s, String t) {
        return solve(s, t);
    }

    private static boolean solve(String s, String t) {
        var sFreq = countChar(s);
        var tFreq = countChar(t);

        if (s.length() != t.length()) return false;

        for (var entry: sFreq.entrySet()) {
            if (!tFreq.containsKey(entry.getKey()) || tFreq.get(entry.getKey()).longValue() != entry.getValue()) return false;
        }

        return true;
    }

    private static Map<Character, Long> countChar(String s) {
        return s.codePoints().mapToObj(item -> (char) item).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
    }
}
