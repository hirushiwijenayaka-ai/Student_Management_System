import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();
                    scanner.nextLine();

                    Student student = new Student(id, name, age, course, gpa);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
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

                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    course = scanner.nextLine();

                    System.out.print("Enter New GPA: ");
                    gpa = scanner.nextDouble();
                    scanner.nextLine();

                    if (manager.updateStudent(id, name, age, course, gpa)) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
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
                    System.out.println("Thank you for using Student Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}