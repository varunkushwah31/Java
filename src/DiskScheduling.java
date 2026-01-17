import java.util.*;

public class DiskScheduling {
    public static int fcfs(int head, int[] req) {
        int total = 0;
        int pos = head;
        for (int r : req) {
            total += Math.abs(pos - r);
            pos = r;
        }
        return total;
    }

    public static int sstf(int head, int[] req) {
        int total = 0;
        int pos = head;
        List<Integer> list = new ArrayList<>();
        for (int r : req) list.add(r);
        while (!list.isEmpty()) {
            int min = Integer.MAX_VALUE, idx = 0;
            for (int i = 0; i < list.size(); i++) {
                int d = Math.abs(pos - list.get(i));
                if (d < min) {
                    min = d;
                    idx = i;
                }
            }
            total += min;
            pos = list.get(idx);
            list.remove(idx);
        }
        return total;
    }

    public static int scan(int head, int[] req, int diskSize) {
        int total = 0;
        int pos = head;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int r : req) {
            if (r < head) left.add(r);
            else right.add(r);
        }
        Collections.sort(left, Collections.reverseOrder());
        Collections.sort(right);

        for (int r : right) {
            total += Math.abs(pos - r);
            pos = r;
        }
        total += Math.abs(pos - (diskSize - 1));
        pos = diskSize - 1;

        for (int r : left) {
            total += Math.abs(pos - r);
            pos = r;
        }
        return total;
    }

    public static int look(int head, int[] req) {
        int total = 0;
        int pos = head;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int r : req) {
            if (r < head) left.add(r);
            else right.add(r);
        }
        Collections.sort(left, Collections.reverseOrder());
        Collections.sort(right);

        for (int r : right) {
            total += Math.abs(pos - r);
            pos = r;
        }
        for (int r : left) {
            total += Math.abs(pos - r);
            pos = r;
        }
        return total;
    }

    public static void main(String[] args) {
        int head = 50;
        int[] req = {82, 170, 43, 140, 24, 16, 190};
        int diskSize = 200;

        System.out.println("FCFS: " + fcfs(head, req));
        System.out.println("SSTF: " + sstf(head, req));
        System.out.println("SCAN: " + scan(head, req, diskSize));
        System.out.println("LOOK: " + look(head, req));
    }
}
