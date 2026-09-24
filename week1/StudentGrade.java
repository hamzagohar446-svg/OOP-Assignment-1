import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student ID: ");
        String studentId = input.nextLine();

        System.out.print("Enter quiz marks (out of 100): ");
        double quiz = input.nextDouble();

        System.out.print("Enter midterm marks (out of 100): ");
        double midterm = input.nextDouble();

        System.out.print("Enter final marks (out of 100): ");
        double finals = input.nextDouble();

        double average = (quiz + midterm + finals) / 3.0;
        String letter = letterGrade(average);
        String result = average >= 50 ? "PASS" : "FAIL";

        System.out.println();
        System.out.println("----- Result -----");
        System.out.println("Name       : " + name);
        System.out.println("Student ID : " + studentId);
        System.out.printf("Average    : %.2f%n", average);
        System.out.println("Grade      : " + letter);
        System.out.println("Status     : " + result);

        input.close();
    }

    private static String letterGrade(double average) {
        if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B";
        } else if (average >= 60) {
            return "C";
        } else if (average >= 50) {
            return "D";
        }
        return "F";
    }
}
