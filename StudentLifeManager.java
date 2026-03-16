import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    int age;
    String major;
    ArrayList<String> courses = new ArrayList<>();
    ArrayList<String> activities = new ArrayList<>();
    ArrayList<Double> grades = new ArrayList<>();

    Student(int id, String name, int age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    void addCourse(String course) {
        courses.add(course);
        System.out.println("Course added.");
    }

    void addActivity(String activity) {
        activities.add(activity);
        System.out.println("Activity added.");
    }

    void addGrade(double grade) {
        grades.add(grade);
        System.out.println("Grade added.");
    }

    void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
        System.out.println("Courses: " + courses);
        System.out.println("Activities: " + activities);
        System.out.println("Grades: " + grades);
        System.out.println("---------------------------");
    }
}

public class StudentLifeManager {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT LIFE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course to Student");
            System.out.println("4. Add Activity to Student");
            System.out.println("5. Add Grade to Student");
            System.out.println("6. Search Student");
            System.out.println("7. Update Student Info");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    addCourseToStudent();
                    break;

                case 4:
                    addActivityToStudent();
                    break;

                case 5:
                    addGradeToStudent();
                    break;

                case 6:
                    searchStudent();
                    break;

                case 7:
                    updateStudentInfo();
                    break;

                case 8:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Major: ");
        String major = scanner.nextLine();

        Student student = new Student(id, name, age, major);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            s.displayInfo();
        }
    }

    static Student findStudentById(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }

    static void addCourseToStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course name: ");
        String course = scanner.nextLine();
        s.addCourse(course);
    }

    static void addActivityToStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter activity name: ");
        String activity = scanner.nextLine();
        s.addActivity(activity);
    }

    static void addGradeToStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        s.addGrade(grade);
    }

    static void searchStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student s = findStudentById(id);
        if (s != null) {
            s.displayInfo();
        } else {
            System.out.println("Student not found.");
        }
    }

    static void updateStudentInfo() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student s = findStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) s.name = name;

        System.out.print("Enter new age (0 to keep current): ");
        int age = scanner.nextInt();
        scanner.nextLine();
        if (age > 0) s.age = age;

        System.out.print("Enter new major (leave blank to keep current): ");
        String major = scanner.nextLine();
        if (!major.isEmpty()) s.major = major;

        System.out.println("Student info updated!");
    }
}