sealed class Vehicle permits Car, Bike {
    void show() {
        System.out.println("This is a vehicle");
    }
}

final class Car extends Vehicle {
    void show() {
        System.out.println("Car running");
    }
}

non-sealed class Bike extends Vehicle {
    void show() {
        System.out.println("Bike running");
    }
}

public class SealedClassExample {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        v1.show();

        Vehicle v2 = new Bike();
        v2.show();
    }
}
