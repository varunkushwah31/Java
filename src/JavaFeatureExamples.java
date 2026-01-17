@FunctionalInterface
interface StringCheck {
    boolean isEmpty(String s);

    default void show() {
        System.out.println("Default method inside Functional Interface");
    }

    static void printMessage() {
        System.out.println("Static method inside Functional Interface");
    }
}

public class JavaFeatureExamples {

    public static boolean checkEmpty(String s) {
        return s.isEmpty();
    }

    class Inner {
        void display() {
            System.out.println("Inside Inner Class");
        }
    }

    public static void main(String[] args) {

        StringCheck lambdaCheck = s -> s.isEmpty();
        System.out.println("Using Lambda: " + lambdaCheck.isEmpty(""));

        StringCheck methodRefCheck = JavaFeatureExamples::checkEmpty;
        System.out.println("Using Method Reference: " + methodRefCheck.isEmpty("Hello"));


        lambdaCheck.show();

        StringCheck.printMessage();

        JavaFeatureExamples outer = new JavaFeatureExamples();
        JavaFeatureExamples.Inner innerObj = outer.new Inner();
        innerObj.display();
    }
}
