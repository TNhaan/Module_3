package LinkedList_ArrayList;

import java.util.ArrayList;

public class Bai_1_ArrayList {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        addLast(10);
        addLast(20);
        addLast(30);
        addLast(40);
        addLast(20);

        addIndex(2, 55);
        addIndex(2, 45);

        setIndex(0, 22);

        System.out.println(arrayList);

        System.out.println(get(0));
        System.out.println((firstIndexOf(30) == -1) ? "Khong tim thay" : firstIndexOf(30));
        System.out.println((lastIndexOf(20) == -1) ? "Khong tim thay" : lastIndexOf(20));

        remove(0);
        removeElement(55);
        System.out.println(arrayList);
    }

    // 1.
    public static void addLast(int element) {
        arrayList.add(arrayList.size(), element);
    }

    // 2.
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append(arrayList.get(i));
        }
        return stringBuilder.toString();
    }

    // 3.
    public static void addIndex(int index, int element) {
        arrayList.add(index, element);
    }

    // 4.
    public static void setIndex(int index, int element) {
        arrayList.set(index, element);
    }

    // 5.
    public static int get(int index) {
        return arrayList.get(index);
    }

    // 6.
    public static int firstIndexOf(int element) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == element) {
                return i + 1;
            }
        }
        return -1;
    }

    // 7.
    public static int lastIndexOf(int element) {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) == element) {
                return i + 1;
            }
        }
        return -1;
    }

    // 8.
    public static void remove(int index) {
        arrayList.remove(index);
    }

    // 9.
    public static void removeElement(int element) {
        arrayList.removeIf(n -> n == element);
    }
}
