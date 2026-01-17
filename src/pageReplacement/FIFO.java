package pageReplacement;

import java.util.*;

public class FIFO {
    public static void fifo(int[] pages, int capacity) {
        Queue<Integer> memory = new LinkedList<>();
        int pageFaults = 0;

        System.out.println("\nFIFO Page Replacement");
        System.out.println("---------------------------");

        for (int page : pages) {
            System.out.print("Page " + page + ": ");
            if (!memory.contains(page)) {
                if (memory.size() == capacity) {
                    int removed = memory.poll();  // Remove oldest page
                    System.out.print("Removed " + removed + ", ");
                }
                memory.add(page);
                pageFaults++;
                System.out.print("Inserted " + page);
            } else {
                System.out.print("Already in memory");
            }

            System.out.println(" → Memory: " + memory);
        }

        System.out.println("Total Page Faults (FIFO): " + pageFaults);
    }

    public static void main(String[] args) {
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3};
        int capacity = 3;

        fifo(pages, capacity);
    }
}
