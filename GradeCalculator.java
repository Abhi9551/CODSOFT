import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Grade Calculator");
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        double totalMarks = 0;
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble();
            totalMarks += marks;
        }

        double averagePercentage = (totalMarks / (numberOfSubjects * 100)) * 100;

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        
        String grade = calculateGrade(averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
