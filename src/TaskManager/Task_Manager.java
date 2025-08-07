package TaskManager;

public class Task_Manager<T> {
    private TaskTask_Manager<T> stackManager = new TaskTask_Manager<T>();
    private QueueTask_Manager<T> queueManager = new QueueTask_Manager<T>();

    public void addToStack(T item) {
        stackManager.push(item);
    }

    public void undoStack() {
        stackManager.pop();
    }

    public void redoStack() {
        stackManager.redo();
    }

    public void addToQueue(T item) {
        queueManager.add(item);
    }

    public void processQueue() {
        queueManager.poll();
    }

    public void showHighestPriorityInQueue() {
        T highest = queueManager.getHighestPriority();
        if (highest != null) {
            System.out.println("Highest Priority Task: " + highest);
        }
    }
}
