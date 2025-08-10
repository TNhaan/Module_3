package Exercise_Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Set<Integer> listHashSet = new HashSet<>();
        Set<Integer> listHasSet2 = new HashSet<>();

        listHashSet.add(10);
        listHashSet.add(20);
        listHashSet.add(30);
        listHashSet.add(10);
        listHashSet.add(40);
        listHashSet.add(30);

        listHasSet2.add(30);
        listHasSet2.add(50);
        listHasSet2.add(40);
        listHasSet2.add(10);
        listHasSet2.add(60);
        listHasSet2.add(70);

        // bai 1
        if (!listHashSet.isEmpty()) {
            System.out.println("a) " + listHashSet);
        } else {
            System.out.println("List empty.");
        }

        // bai 2
        // For Each
        int sum = 0;
        for (Integer i : listHashSet) {
            sum += i;
        }
        // hasNext
        int sum2 = 0;
        Iterator<Integer> iterator = listHashSet.iterator();
        while (iterator.hasNext()) {
            sum2 += iterator.next();
        }

        System.out.println("b) Sum: " + sum);
        System.out.println("b) Sum: " + sum2);

        // bai 3
        // retain method
        System.out.println("\nc) Before retainAll:\n" + "List 1: " + listHashSet + "\nList 2: " + listHasSet2);
        listHasSet2.retainAll(listHashSet);
        int sum3 = 0;
        for (Integer i : listHasSet2) {
            sum3 += i;
        }


        System.out.println("After retainAll\n" + listHasSet2);
        System.out.println("Sum: " + sum3);

        // bai 4
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (Integer i : listHashSet) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        System.out.println("\n" + listHashSet);
        System.out.printf("d) Max: %-4d| Min: %-4d", max, min);
    }
}
