import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(id, name, marks));

        System.out.println("Student added successfully!");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\nStudent Records:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void searchStudent(String id) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("Student Found:");
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getMarks();
        }

        double average = total / students.size();

        System.out.printf("Average Mark: %.2f%n", average);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Mark");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    searchStudent(id);
                    break;

                case 4:
                    calculateAverage();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}