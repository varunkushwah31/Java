class EncapsulatedTermDay {

    private int day;
    private int week;

    public EncapsulatedTermDay(int day, int week) {
        setDay(day);
        setWeek(week);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 0 || day > 6) {
            throw new IllegalArgumentException("Invalid day! Day must be between 0 and 6.");
        }
        this.day = day;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        if (week < 0 || week > 7) {
            throw new IllegalArgumentException("Invalid week! Week must be between 0 and 7.");
        }
        this.week = week;
    }

    public String toString() {
        return "Week " + week + ", Day " + day;
    }
}

class StackOverflowException extends Exception {
    public StackOverflowException(String message) {
        super(message);
    }
}

class StackUnderflowException extends Exception {
    public StackUnderflowException(String message) {
        super(message);
    }
}

class Stack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    public void push(int value) throws StackOverflowException {
        if (top == capacity - 1) {
            throw new StackOverflowException("Stack is full! Cannot push " + value);
        }
        stackArray[++top] = value;
    }

    public int pop() throws StackUnderflowException {
        if (top == -1) {
            throw new StackUnderflowException("Stack is empty! Cannot pop.");
        }
        return stackArray[top--];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class StackImplementation {
    public static void main(String[] args) {

        System.out.println("===== EncapsulatedTermDay Test =====");

        try {
            EncapsulatedTermDay t = new EncapsulatedTermDay(3, 5);
            System.out.println(t);
            t.setDay(10);
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("\n===== Stack Test =====");

        Stack s = new Stack(3);

        try {
            s.push(10);
            s.push(20);
            s.push(30);
            System.out.println("Stack is full? " + s.isFull());
            s.push(40);
        } catch (StackOverflowException e) {
            System.out.println("Overflow Error: " + e.getMessage());
        }

        try {
            System.out.println("Popped: " + s.pop());
            System.out.println("Popped: " + s.pop());
            System.out.println("Popped: " + s.pop());
            System.out.println("Popped: " + s.pop());
        } catch (StackUnderflowException e) {
            System.out.println("Underflow Error: " + e.getMessage());
        }
    }
}
