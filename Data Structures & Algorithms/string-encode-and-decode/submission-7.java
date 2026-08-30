class Solution {

    public static String encode(List<String> strs) {
        var encoded = new StringBuilder();

        for (var item : strs) {
            var len = item.length();
            encoded.append(len);
            encoded.append("#");
            encoded.append(item);
        }

        return encoded.toString();
    }

    public static List<String> decode(String str) {
        var decoded = new ArrayList<String>();
        var i = 0;

        while (i < str.length()) {
            var delimiterIndex = str.indexOf('#', i);
            var len = Integer.parseInt(str.substring(i, delimiterIndex));
            var next = delimiterIndex + 1 + len;
            decoded.add(str.substring(delimiterIndex + 1, next));
            i = next;
        }

        return decoded;
    }
}
