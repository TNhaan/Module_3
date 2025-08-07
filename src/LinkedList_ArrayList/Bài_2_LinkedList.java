package LinkedList_ArrayList;

import javax.swing.*;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Bài_2_LinkedList {

    private static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        Bài_2_LinkedList linkedList = new Bài_2_LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);

        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addLast(30);
        linkedList.addLast(60);

        linkedList.addIndex(2, 90);
        linkedList.addIndex(3, 91);

        System.out.println(linkedList);

//        System.out.println(linkedList.removeFirst());
//        System.out.println(linkedList.removeLast());
//
//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());

//        linkedList.removeIndex(2);
//        System.out.println(linkedList);

//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());
//        System.out.println(linkedList.getIndex(2));

//        linkedList.setIndex(2, 333);
//        linkedList.getFirstIndex(90);
        linkedList.getLastIndex(30);
        System.out.println(linkedList);
    }

    // 1.
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // 2.
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(temp.value).append("\t");
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    // 3.
    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // 4.
    public void addIndex(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Lỗi: Ngoài phạm vi!");
        } else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    // 5.
    public Integer removeFirst() {
        if (head == null) {
            return null;
        } else if (size == 1) {
            head = null;
            tail = null;
        }
        Node temp = head;
        head = head.next;
        size--;
        return temp.value;
    }

    // 6.
    public Integer removeLast() {
        if (head == null) {
            return null;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }


        int value = tail.value;
        tail = temp;
        tail.next = null;

        size--;
        return value;
    }

    // 7.
    public void removeIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("Lỗi: Ngoài phạm vi!");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        }
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    // 8.
    public Integer getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }


    // 9.
    public Integer getLast() {
        if (tail == null) {
            return null; // hoặc throw exception nếu muốn
        }
        return tail.value;
    }


    // 10
    public Integer getIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("Loi: Ngoai pham vi");
        }
        if (index == 0) {
            getFirst();
        }
        if (index == size - 1) {
            getLast();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    // 11
    public void setIndex(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Loi: Ngoai pham vi");
        }
        removeIndex(index);
        addIndex(index - 1, element);
    }

    // 12
    public void getFirstIndex(int element) {
        boolean check = false;
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                System.out.println("Vi tri dau tien tim thay: " + i);
            }
            temp = temp.next;
            check = true;
        }
        if (!check) {
            System.out.println("Khong tim thay.");
        }
    }

    // 13.
    public void getLastIndex(int element) {
        Node temp = head;
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (temp.value == element) {
                result = i - 1;
            }
        }
        if (result == -1) {
            System.out.println("Khong tim thay.");
        } else {
            System.out.println("Vi tri cuoi cung tim thay: " + result);
        }
    }

}
