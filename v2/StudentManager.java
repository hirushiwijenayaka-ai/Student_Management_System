import java.util.ArrayList;

/**
 * Manages all student-related operations.
 */
public class StudentManager {

    // List to store student records
    private ArrayList<Student> students = new ArrayList<>();

    /**
     * Adds a new student after checking for duplicate IDs.
     *
     * @param student Student object to be added
     * @return true if added successfully, false if Student ID already exists
     */
    public boolean addStudent(Student student) {

        if (searchStudent(student.getStudentId()) != null) {
            return false; // Duplicate ID found
        }

        students.add(student);
        return true;
    }

    /**
     * Displays all students.
     */
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n========== Student Records ==========");

        for (Student student : students) {
            student.displayStudent();
        }
    }

    /**
     * Searches for a student using Student ID.
     *
     * @param studentId Student ID
     * @return Student object if found, otherwise null
     */
    public Student searchStudent(String studentId) {

        for (Student student : students) {

            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }

        }

        return null;
    }

    /**
     * Updates an existing student's details.
     *
     * @return true if update is successful
     */
    public boolean updateStudent(String studentId,
                                 String name,
                                 int age,
                                 String course,
                                 double gpa) {

        Student student = searchStudent(studentId);

        if (student == null) {
            return false;
        }

        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setGpa(gpa);

        return true;
    }

    /**
     * Deletes a student record.
     *
     * @param studentId Student ID
     * @return true if deleted successfully
     */
    public boolean deleteStudent(String studentId) {

        Student student = searchStudent(studentId);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    /**
     * Returns the total number of students.
     */
    public int getStudentCount() {
        return students.size();
    }
}