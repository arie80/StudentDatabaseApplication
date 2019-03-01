package studentdatabaseapp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance;
    private static int costOfCourse = 600;
    private static int id = 1000;
    private Scanner in;

    // Constructor prompt user to enter student's name and year
    public Student() {
        in = new Scanner(System.in);
        System.out.println("Enter student first name: ");

        String fname;

        while ((fname = in.nextLine()).isEmpty()) {
            System.out.println("First name can not be empty! try again...");
        }

        this.firstName = fname;

        System.out.println("Enter student last name: ");
        String lname;
        while ((lname = in.nextLine()).isEmpty()) {
            System.out.println("Last name can not be empty! try again...");
        }
        this.lastName = lname;

        System.out.println("1 - Freshment\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");

        this.gradeYear = in.nextInt();
        in.nextLine(); // Consumes "\n"

        setStudentID();
    }

    // Generate an Id
    public void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    public void enroll() {
        String[] courseList = { "math", "sport", "computer", "biologi", "physics", "english", "art" };
        List<String> str = Arrays.asList(courseList);

        for (int i = 0; i < str.size(); i++) {
            System.out.println(
                    "Enter course to enroll: \n(math, sport, computer, biologi, physics, english, art) or Q to quit: ");
            String course;
            while ((course = in.nextLine()).isEmpty()) {
                System.out.println(
                        "Please choose the course to enroll!\n(math, sport, computer, biologi, physics, english, art) or Q to quit:");
            }
            if (str.contains(course.toLowerCase()) && !course.equalsIgnoreCase("q")) {
                courses += "\n- " + course;
                tuitionBalance += costOfCourse;
            } else {
                break;
            }
        }
        System.out.println("ENROLLED IN: " + courses);
    }

    // View Balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter you payment: $");
        int payment = in.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
    }

    // Show status
    @Override
    public String toString() {
        return "\nName: " + firstName + " " + lastName + "\nGrade Level: " + gradeYear + "\nStudent ID: " + studentID
                + "\nCourses Enrolled: " + courses + "\nBalance: $" + tuitionBalance + "\n";
    }
}
