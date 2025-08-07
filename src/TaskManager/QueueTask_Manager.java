package TaskManager;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTask_Manager<T> {
    private Queue<T> queue = new LinkedList<>();

    public void add(T item) {
        queue.add(item);
        System.out.println("Added to queue: " + item);
    }

    public void poll() {
        if (!queue.isEmpty()) {
            T item = queue.poll();
            System.out.println("Processed from queue: " + item);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public T getHighestPriority() {
        if (queue.isEmpty()) return null;

        if (!(queue.peek() instanceof Task)) {
            System.out.println("Can't determine priority – item is not Task.");
            return null;
        }

        T highest = queue.poll();
        Queue<T> temp = new LinkedList<>();
        temp.add(highest);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            Task currentTask = (Task) current;
            Task highestTask = (Task) highest;
            if (currentTask.getPriority() < highestTask.getPriority()) {
                highest = current;
            }
            temp.add(current);
        }

        queue = temp;
        return highest;
    }

    public T peek() {
        return queue.peek();
    }
}
