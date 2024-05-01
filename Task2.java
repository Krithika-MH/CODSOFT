import java.util.*;

public class Task2 {
    // Constants
    private static final int n = 5; // Num subjects
    private static final int max = 100; // Max per subject
    private static final int grand = n * max; // Total marks

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a[] = new double[n];
        double total = 0.0, avg = 0.0;
        char grade;
        String name, usn;

        // Input student details
        System.out.println("Enter the Student details:");
        System.out.print("Enter the name: ");
        name = sc.next();
        System.out.print("Enter the USN: ");
        usn = sc.next();

        // Input marks in 5 subjects
        System.out.println("Enter the marks in " + n + " subjects:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the mark in Subject " + (i + 1) + ": ");
            a[i] = sc.nextDouble();
            // Validate input marks
            while (a[i] < 0 || a[i] > max) {
                System.out.println("Invalid input! Marks should be between 0 and " + max + ".");
                System.out.print("Enter the mark in Subject " + (i + 1) + " again: ");
                a[i] = sc.nextDouble();
            }
            total += a[i];
        }
        avg = total / n;

        // Calculate grade
        if (avg >= 80) {
            grade = 'A';
        } else if (avg >= 60) {
            grade = 'B';
        } else if (avg >= 40) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        // Display Student Grade Report
        System.out.println("\n\t\t  STUDENT GRADE REPORT");
        System.out.println("\t\tName        : " + name);
        System.out.println("\t\tUSN         : " + usn);
        for (int i = 0; i < n; i++) {
            System.out.println("\t\tSubject " + (i + 1) + "   : " + a[i] + " / " + max);
        }
        System.out.println("\t\tTotal Marks : " + total + " / " + grand);
        System.out.println("\t\tAverage     : " + avg);
        System.out.print("\t\tGrade       : " + grade);

        // Display grade description
        switch (grade) {
            case 'A':
                System.out.print("  -  Excellent!");
                break;
            case 'B':
                System.out.print("  -  Good!");
                break;
            case 'C':
                System.out.print("  -  Fair!");
                break;
            case 'D':
                System.out.print("  -  Satisfactory!");
                break;
            default:
                System.out.print("  -  Fail!");
        }
    }
}
