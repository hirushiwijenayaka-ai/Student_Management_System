import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice = 0;

        do {

            System.out.println("\n========== Student Management System ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Display Total Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Validate menu input
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();

                    // Validate Age
                    int age;

                    while (true) {

                        try {

                            System.out.print("Enter Age: ");
                            age = scanner.nextInt();

                            if (age > 0) {
                                scanner.nextLine();
                                break;
                            }

                            System.out.println("Age must be greater than 0.");

                        } catch (InputMismatchException e) {

                            System.out.println("Invalid age. Please enter a number.");
                            scanner.nextLine();

                        }

                    }

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    // Validate GPA
                    double gpa;

                    while (true) {

                        try {

                            System.out.print("Enter GPA (0.0 - 4.0): ");
                            gpa = scanner.nextDouble();

                            if (gpa >= 0 && gpa <= 4.0) {
                                scanner.nextLine();
                                break;
                            }

                            System.out.println("GPA must be between 0.0 and 4.0.");

                        } catch (InputMismatchException e) {

                            System.out.println("Invalid GPA.");
                            scanner.nextLine();

                        }

                    }

                    Student student = new Student(id, name, age, course, gpa);

                    if (manager.addStudent(student)) {
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Student ID already exists.");
                    }

                    break;

                case 2:

                    manager.viewStudents();
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();

                    Student found = manager.searchStudent(id);

                    if (found != null) {
                        found.displayStudent();
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID to update: ");
                    id = scanner.nextLine();

                    if (manager.searchStudent(id) == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();

                    while (true) {

                        try {

                            System.out.print("Enter New Age: ");
                            age = scanner.nextInt();

                            if (age > 0) {
                                scanner.nextLine();
                                break;
                            }

                            System.out.println("Age must be greater than 0.");

                        } catch (InputMismatchException e) {

                            System.out.println("Invalid age.");
                            scanner.nextLine();

                        }

                    }

                    System.out.print("Enter New Course: ");
                    course = scanner.nextLine();

                    while (true) {

                        try {

                            System.out.print("Enter New GPA: ");
                            gpa = scanner.nextDouble();

                            if (gpa >= 0 && gpa <= 4.0) {
                                scanner.nextLine();
                                break;
                            }

                            System.out.println("GPA must be between 0.0 and 4.0.");

                        } catch (InputMismatchException e) {

                            System.out.println("Invalid GPA.");
                            scanner.nextLine();

                        }

                    }

                    if (manager.updateStudent(id, name, age, course, gpa)) {
                        System.out.println("Student updated successfully.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Student ID to delete: ");
                    id = scanner.nextLine();

                    if (manager.deleteStudent(id)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 6:

                    System.out.println("Total Students : "
                            + manager.getStudentCount());

                    break;

                case 7:

                    System.out.println("Thank you for using the Student Management System.");

                    break;

                default:

                    System.out.println("Invalid menu option.");

            }

        } while (choice != 7);

        scanner.close();
    }
}