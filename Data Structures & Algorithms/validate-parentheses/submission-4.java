class Solution {
    public boolean isValid(String s) {
        return solve(s);
    }

    private static boolean solve(String s) {
        var stack = new Stack<Character>();

        for (var item : s.toCharArray()) {
            if (item == '[' || item == '(' || item == '{') {
                stack.push(item);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if ((item == ']' && stack.pop() != '[') ||
                        (item == ')' && stack.pop() != '(') ||
                        (item == '}' && stack.pop() != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
