class Solution {
    public boolean isPalindrome(String s) {
        return solve(s);
    }

    private static boolean solve(String str) {
        var start = 0;
        var end = str.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(str.charAt(start))) {
                start++;
                continue;
            } else if (!Character.isLetterOrDigit(str.charAt(end))) {
                end--;
                continue;
            } else if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
