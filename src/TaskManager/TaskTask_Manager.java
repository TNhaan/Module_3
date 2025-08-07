package TaskManager;

import java.util.Stack;

public class TaskTask_Manager<T> {
    private Stack<T> stack = new Stack<>();
    private Stack<T> redoStack = new Stack<>();

    public void push(T item) {
        stack.push(item);
        System.out.println("Pushed: " + item);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            T item = stack.pop();
            redoStack.push(item);
            System.out.println("Undo: " + item);
        } else {
            System.out.println("Stack is empty.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            T item = redoStack.pop();
            stack.push(item);
            System.out.println("Redo: " + item);
        } else {
            System.out.println("No task to redo.");
        }
    }

    public T peek() {
        return stack.isEmpty() ? null : stack.peek();
    }
}
