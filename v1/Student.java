public class Student {

    // Attributes
    private String studentId;
    private String name;
    private int age;
    private String course;
    private double gpa;

    // Constructor
    public Student(String studentId, String name, int age, String course, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
        this.gpa = gpa;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public double getGpa() {
        return gpa;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    // Display student information
    public void displayStudent() {
        System.out.println("--------------------------------");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Course     : " + course);
        System.out.println("GPA        : " + gpa);
    }
}