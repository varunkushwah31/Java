import java.util.Arrays;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println(max(read));
        System.out.println(oddSum((50)));
        int[] arr = {1,24,55,32,14,0,32};
        System.out.println(Arrays.toString(minMaxArray(arr)));
        isPalindrome("nitin");
    }
    private static int max(Scanner read){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            max = Math.max(max, read.nextInt());
        }
        return max;
    }
    private static int oddSum(int n){
        int half = n/2;
        return (half*half);
    }
    private static int[] minMaxArray(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }
        return new int[]{min,max};

    }
    private static void isPalindrome(String s){
        System.out.println("The Length of String is : " + s.length());
        int i = 0;
        int j = s.length()-1;
        boolean isSame = true;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                isSame = false;
                break;
            }
            i++;
            j--;
        }
        if(isSame){
            System.out.println("String " + s +" is Palindrome");
        }else{
            System.out.println("String " + s +" is not Palindrome");
        }
    }
}
