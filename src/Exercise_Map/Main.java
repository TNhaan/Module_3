package Exercise_Map;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int choice;
        do {
            System.out.println("======Lựa chọn======");
            System.out.println("1. Đếm số lần xuất hiện của từng từ.");
            System.out.println("2. Kiểm tra tên duy nhất và tên trùng.");
            System.out.println("3. Kết thúc chương trình");
            System.out.println("====================");
            System.out.print("Mời lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> countWord();
                case 2 -> checkUniqueName();
                case 3 -> System.out.println("Chương trình kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 3);
    }

    public static void countWord() {
        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String string = scanner.nextLine();
        System.out.println(string);
        String[] words = string.toLowerCase().replaceAll("[^a-zA-Z\\s+]", "").split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        wordCountMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void checkUniqueName() {
        int size;
        while (true) {
            System.out.print("Số tên muốn nhập vào: ");
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Hãy nhập số nguyên!");
            }
        }
        String[] names = new String[size];
        System.out.println("Nhập tên: ");
        for (int i = 0; i < size; i++) {
            System.out.print("Người thứ " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        Map<String, Integer> nameCountMap = new HashMap<>();

        for (String name : names) {
            if (nameCountMap.containsKey(name)) {
                nameCountMap.put(name, nameCountMap.get(name) + 1);
            } else {
                nameCountMap.put(name, 1);
            }
        }
        List<String> onceWords = new ArrayList<>();
        List<String> manyWords = new ArrayList<>();

        nameCountMap.forEach((key, value) -> {
            if (value == 1) {
                onceWords.add(key);
            } else {
                manyWords.add(key + " (" + value + " times)");
            }
        });

        System.out.println("Những tên chỉ xuất hiện 1 lần: ");
        for (String onceWord : onceWords) {
            System.out.println(onceWord);
        }

        System.out.println("\nNhững tên xuất hiện hơn 1 lần:");
        for (String manyWord : manyWords) {

            System.out.println(manyWord);
        }
    }
}
