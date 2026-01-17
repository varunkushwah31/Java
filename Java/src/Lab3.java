import java.io.*;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nSalary: " + salary;
    }

    public String toFileString() {
        return id + "," + name + "," + salary;
    }

    public static Employee fromFileString(String data) {
        String[] parts = data.split(",");
        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        double salary = Double.parseDouble(parts[2]);
        return new Employee(id, name, salary);
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(id, name, salary);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("emp.txt"))) {
            writer.write(emp.toFileString());
            System.out.println("Employee details written to emp.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("emp.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                Employee readEmp = Employee.fromFileString(line);
                System.out.println("\nEmployee details read from file:");
                System.out.println(readEmp);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        scanner.close();
    }
}

