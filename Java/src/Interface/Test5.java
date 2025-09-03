package Interface;
//abstract
abstract class Payment {
    double amount;
    String transactionId;

    Payment(double amount, String transactionId) {
        this.amount = amount;
        this.transactionId = transactionId;}

    void generateReceipt() {
        System.out.println("Receipt: Txn " + transactionId + " for amount " + amount);
    }
    abstract void processPayment();}

// Interface
interface Refundable {
    void refund(double amount);
}

interface EMIAvailable {
    void payInInstallments(int months);
}
class CreditCardPayment extends Payment implements Refundable, EMIAvailable {
    CreditCardPayment(double amount, String txnId) {
        super(amount, txnId);}
    @Override
    void processPayment() {
        System.out.println("Processing Credit Card payment of " + amount);
    }
    @Override
    public void refund(double amount) {
        System.out.println("Refunding " + amount + " to Credit Card.");
    }
    @Override
    public void payInInstallments(int months) {
        System.out.println("Paying in " + months + " monthly installments.");
    }
}
class UPIPayment extends Payment implements Refundable {
    UPIPayment(double amount, String txnId) {
        super(amount, txnId);
    }
    @Override
    void processPayment() {
        System.out.println("Processing UPI payment of " + amount);
    }
    @Override
    public void refund(double amount) {
        System.out.println("Refunding " + amount + " to UPI account.");
    }}
class CashPayment extends Payment {
    CashPayment(double amount, String txnId) {
        super(amount, txnId);
    }
    @Override
    void processPayment() {
        System.out.println("Processing Cash payment of " + amount);
    }}
public class Test5 {
    public static void main(String[] args) {
        CreditCardPayment p1 = new CreditCardPayment(5000, "TXN123");
        UPIPayment p2 = new UPIPayment(2000, "TXN124");
        CashPayment p3 = new CashPayment(1000, "TXN125");

        p1.processPayment(); p1.generateReceipt();
        p2.processPayment(); p2.generateReceipt();
        p3.processPayment(); p3.generateReceipt();

        p1.refund(1000);
        p1.payInInstallments(6);

        p2.refund(500);
    }
}

