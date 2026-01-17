package Exception;

import java.util.Scanner;

public class Exception2 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int a = read.nextInt();
        int b = read.nextInt();
        try {
            System.out.println(a/b);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
