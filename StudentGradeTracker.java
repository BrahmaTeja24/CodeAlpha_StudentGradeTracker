import java.util.ArrayList;
import java.util.Scanner;

// Student class to store student details
class Student {
    String name;
    int grade;

    // Constructor
    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();

    // Function to add student
    public static void addStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.next();

        System.out.print("Enter student grade: ");
        int grade = sc.nextInt();

        students.add(new Student(name, grade));

        System.out.println("Student added successfully!\n");
    }

    // Function to display all students
    public static void displayStudents() {
        if (students.size() == 0) {
            System.out.println("No student records found.\n");
            return;
        }

        System.out.println("\n---- Student Records ----");
        for (Student s : students) {
            System.out.println("Name: " + s.name + " | Grade: " + s.grade);
        }
        System.out.println();
    }

    // Function to calculate average grade
    public static void calculateAverage() {
        if (students.size() == 0) {
            System.out.println("No data available.\n");
            return;
        }

        int sum = 0;
        for (Student s : students) {
            sum += s.grade;
        }

        double average = (double) sum / students.size();
        System.out.println("Average Grade: " + average + "\n");
    }

    // Function to find highest grade
    public static void highestGrade() {
        if (students.size() == 0) {
            System.out.println("No data available.\n");
            return;
        }

        Student highest = students.get(0);

        for (Student s : students) {
            if (s.grade > highest.grade) {
                highest = s;
            }
        }

        System.out.println("Highest Grade: " + highest.grade + " (Student: " + highest.name + ")\n");
    }

    // Function to find lowest grade
    public static void lowestGrade() {
        if (students.size() == 0) {
            System.out.println("No data available.\n");
            return;
        }

        Student lowest = students.get(0);

        for (Student s : students) {
            if (s.grade < lowest.grade) {
                lowest = s;
            }
        }

        System.out.println("Lowest Grade: " + lowest.grade + " (Student: " + lowest.name + ")\n");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Find Highest Grade");
            System.out.println("5. Find Lowest Grade");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    calculateAverage();
                    break;

                case 4:
                    highestGrade();
                    break;

                case 5:
                    lowestGrade();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }

        } while (choice != 6);

        sc.close();
    }
}