class MinStack {

    private int min;
    private int top;
    private final List<Integer> stack;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.top = -1;
        this.min = 0;
    }

    public void push(int val) {
        stack.add(val);
        top++;
        if (val < min) min = val;
    }

    public void pop() {
        stack.remove(top);
        top--;
        min = 0;
    }

    public int top() {
        return stack.get(top);
    }

    public int getMin() {
        if (min == 0) computeMin();
        return min;
    }

    private void computeMin() {
        min = stack.stream().min(Comparator.naturalOrder()).orElseThrow();
    }
}
