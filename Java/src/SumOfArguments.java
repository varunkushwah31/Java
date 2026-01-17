public class SumOfArguments {
    public static void main(String[] args) {
        int sum = 0;

        for (String arg : args) {
            try {
                int num = Integer.parseInt(arg);
                sum += num;
            } catch (NumberFormatException e) {
                System.out.println(arg + " is not a valid integer.");
            }
        }

        System.out.println("Sum of command line arguments: " + sum);
    }
}

