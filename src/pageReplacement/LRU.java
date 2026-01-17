package pageReplacement;

import java.util.*;

public class LRU {

    public static void lru(int[] pages, int capacity) {
        ArrayList<Integer> memory = new ArrayList<>();
        int pageFaults = 0;

        System.out.println("\nLRU Page Replacement");
        System.out.println("---------------------------");

        for (int page : pages) {
            System.out.print("Page " + page + ": ");
            if (!memory.contains(page)) {
                if (memory.size() == capacity) {
                    int removed = memory.remove(0);
                    System.out.print("Removed " + removed + ", ");
                }
                memory.add(page);
                pageFaults++;
                System.out.print("Inserted " + page);
            }
            else {
                memory.remove((Integer) page);
                memory.add(page);
                System.out.print("Already in memory → Marked as recently used");
            }
            System.out.println(" → Memory: " + memory);
        }
        System.out.println("Total Page Faults (LRU): " + pageFaults);
    }

    public static void main(String[] args) {
        int[] pages = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3};
        int capacity = 3;

        lru(pages, capacity);
    }
}
