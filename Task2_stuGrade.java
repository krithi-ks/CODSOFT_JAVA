// JAVA PROGRAM - CODSOFT
// TASK 2 - STUDENT GRADE CALCULATOR

import java.util.Scanner;

class StudentGrade 
{
    static public void main (String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Read number of subjects
        System.out.print("\nEnter the number of subjects: ");
        int n = input.nextInt();

        // Initializing array
        String[] subj = new String[n];
        float[] marks = new float[n]; 

        float sum = 0;
        // Read the name of the subject and marks
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter the name of the subject " + (i + 1) + " : ");
            subj[i] = input.next();
            System.out.print("Enter the marks of " + subj[i] + " (out of 100) : ");
            marks[i] = input.nextFloat();
            // Add the grades
            sum += marks[i];
        }
         
        float avgPer = sum / n;

        // Grade calculation
        char grade;
        if (avgPer >= 90) {
            grade = 'A';
        } else if (avgPer >= 80) {
            grade = 'B';
        } else if (avgPer >= 70) {
            grade = 'C';
        } else if (avgPer >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Student Grade List
        System.out.println("\nYOUR GRADE DETAILS:");
        for  (int i = 0; i < n; i++) 
            System.out.println((i + 1)  + ". " + subj[i] + " = " + marks[i]);

        // Total marks
        System.out.println("\nTOTAL MARKS = " + (int) sum);
        // Average percentage
        System.out.printf("YOUR AVERAGE PERCENTAGE IS : %.2f%%" , avgPer);
        // Grade
        System.out.printf("\nYOUR GRADE IS : \"%c\"", grade);
        input.close();
    }
}