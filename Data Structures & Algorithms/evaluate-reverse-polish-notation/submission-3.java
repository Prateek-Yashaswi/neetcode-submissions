class Solution {
    public int evalRPN(String[] tokens) {
        return solve(tokens);
    }

    private static int solve(String[] tokens) {
        var stack = new Stack<Integer>();
        var operations = "+-/*";

        for (String current : tokens) {
            if (!operations.contains(current)) {
                stack.push(Integer.parseInt(current));
            } else {
                var b = stack.pop();
                var a = stack.pop();

                var result = switch (current) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    default -> a / b;
                };
                
                stack.push(result);
            }
        }

        return stack.peek();
    }
}