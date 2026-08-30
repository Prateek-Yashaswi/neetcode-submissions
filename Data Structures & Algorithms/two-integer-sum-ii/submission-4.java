class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return solveV2(numbers, target);
    }

    private static int[] solve(int[] numbers, int target) {
        for (var slow = 0; slow < numbers.length - 1; slow++) {
            for (var fast = slow + 1; fast < numbers.length; fast++) {
                if (numbers[slow] + numbers[fast] == target) {
                    return new int[]{slow + 1, fast + 1};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] solveV2(int[] numbers, int target) {
        var p1 = 0;
        var p2 = numbers.length - 1;

        while (p1 < p2) {
            var num1 = numbers[p1];
            var num2 = numbers[p2];
            var sum = num1 + num2;

            if (sum > target) {
                p2--;
            } else if (sum < target) {
                p1++;
            } else {
                return new int[]{p1 + 1, p2 + 1};
            }
        }

        return new int[]{-1, -1};
    }
}
