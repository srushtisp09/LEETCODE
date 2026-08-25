 class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    public int pop() {
        if (empty()) {
            System.out.println("Stack empty");
            return -1;
        }
        int top = -1;
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            top = q1.remove();
        } else {
            while (q2.size() > 1) {
                q1.add(q2.remove());
            }
            top = q2.remove();
        }
        return top;
    }

    public int top() {
        if (empty()) {
            System.out.println("Stack empty");
            return -1;
        }
        int top = -1;
        if (!q1.isEmpty()) {
            while (q1.size() > 0) {
                top = q1.remove();
                q2.add(top);
            }
        } else {
            while (q2.size() > 0) {
                top = q2.remove();
                q1.add(top);
            }
        }
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */