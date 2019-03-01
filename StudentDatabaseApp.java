package studentdatabaseapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {

        System.out.println("Enter number of new students to enroll:");
        Scanner in = new Scanner(System.in);
        try {
            int numOfStudents = in.nextInt();
            Student[] students = new Student[numOfStudents];

            for (Student student : students) {
                student = new Student();
                student.enroll();
                student.payTuition();
                System.out.println(student.toString());
            }
            in.close();
        } catch (InputMismatchException e) {
            System.out.println("Invalid number!");
        }
    }
}
