package Test;

abstract class Payments{
    double amount;
    String id;
    Payments(double amount,String id){
        this.amount = amount;
        this.id = id;
    }
    void generateReceipt(){
        System.out.println("Transaction id: " + id + "is Generated for amount :" + amount );
    }
    abstract void pay();
}
interface Refundable{
    void refund(double amount);
}
interface CancelRide{
    void cancelRide();
}

class Car extends Payments implements Refundable,CancelRide{
    Car(double amount,String id){
        super(amount,id);
    }
    @Override
    public void refund(double amount){
        System.out.println("The Refunded Amount for Cancelling ride is :" + amount*0.6);
    }
    @Override
    public void cancelRide(){
        System.out.println("Ride Got Cancelled");
    }
    @Override
    public void pay(){
        System.out.println("Car booking payment of " + amount + " done for booking " + id);
    }
}
class Train extends Payments implements Refundable,CancelRide{
    Train(double amount,String id){
        super(amount,id);
    }
    @Override
    void pay() {
        System.out.println("Train ticket payment of " + amount + " done for booking " + id);
    }
    public void refund(double amount){
        System.out.println("The Refunded Amount for Cancelling Ticket is :" + amount*0.8);
    }
    @Override
    public void cancelRide() {
        System.out.println("Train ride with booking " + id + " got cancelled");
    }

}

class Bus extends Payments {
    Bus(double amount, String id) {
        super(amount, id);
    }

    @Override
    void pay() {
        System.out.println("Bus booking payment of " + amount + " done for booking " + id);
    }

    @Override
    void generateReceipt() {
        System.out.println("Bus ticket generated with booking ID: " + id + " for amount: " + amount);
    }
}

public class QuickRide {
    public static void main(String[] args) {
        Car carBooking = new Car(500, "CAB101");
        carBooking.pay();
        carBooking.generateReceipt();
        carBooking.cancelRide();
        carBooking.refund(500);

        System.out.println();

        Train trainBooking = new Train(1200, "TRN202");
        trainBooking.pay();
        trainBooking.generateReceipt();
        trainBooking.cancelRide();
        trainBooking.refund(1200);

        System.out.println();

        Bus busBooking = new Bus(200, "BUS303");
        busBooking.pay();
        busBooking.generateReceipt();
    }
}
