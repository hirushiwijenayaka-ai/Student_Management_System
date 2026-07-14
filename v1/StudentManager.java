import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // View All Students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search Student
    public Student searchStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    // Update Student
    public boolean updateStudent(String studentId, String name, int age, String course, double gpa) {

        Student student = searchStudent(studentId);

        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            student.setGpa(gpa);
            return true;
        }

        return false;
    }

    // Delete Student
    public boolean deleteStudent(String studentId) {

        Student student = searchStudent(studentId);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }
}
