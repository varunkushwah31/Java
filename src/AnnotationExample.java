import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value();
}

class AnnotationDemo {

    @Deprecated
    void oldMethod() {
        System.out.println("This is a deprecated method");
    }

    @MyAnnotation(value = "Custom Annotation Applied")
    void customAnnotatedMethod() {
        System.out.println("Custom Annotation method executed");
    }
}

public class AnnotationExample {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        AnnotationDemo obj = new AnnotationDemo();

        obj.oldMethod(); // deprecated method
        obj.customAnnotatedMethod(); // custom annotation
    }
}
