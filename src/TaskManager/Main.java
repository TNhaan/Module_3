package TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task_Manager<Task> manager = new Task_Manager<>();

        while (true) {
            System.out.println("\n==== TASK MANAGER ====");
            System.out.println("1. Thêm công việc vào Stack");
            System.out.println("2. Undo công việc (Stack)");
            System.out.println("3. Redo công việc");
            System.out.println("4. Thêm công việc vào Queue");
            System.out.println("5. Xử lý công việc trong Queue");
            System.out.println("6. Xem công việc ưu tiên cao nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    Task task = inputTask(sc);
                    manager.addToStack(task);
                }
                case 2 -> manager.undoStack();
                case 3 -> manager.redoStack();
                case 4 -> {
                    Task task = inputTask(sc);
                    manager.addToQueue(task);
                }
                case 5 -> manager.processQueue();
                case 6 -> manager.showHighestPriorityInQueue();
                case 0 -> {
                    System.out.println("Chương trình kết thúc!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static Task inputTask(Scanner sc) {
        System.out.print("Nhập tên công việc: ");
        String name = sc.nextLine();
        System.out.print("Nhập độ ưu tiên (số nhỏ = ưu tiên cao): ");
        int priority = Integer.parseInt(sc.nextLine());
        return new Task(name, priority);
    }
}
