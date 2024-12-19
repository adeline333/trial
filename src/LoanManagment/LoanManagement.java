package LoanManagment;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoanManagement {

    // Abstract Loan class
    abstract static class Loan {
        protected double loanAmount;
        protected double interestRate = 0.07; // 7% interest rate

        public double calculateTakeHome() {
            return loanAmount * (1 - interestRate);
        }

        public double calculateInterestPerMonth() {
            return loanAmount * interestRate / 12;
        }

        public double calculateInterestPerYear() {
            return loanAmount * interestRate;
        }
    }

    // LoanOne class
    static class LoanOne extends Loan {
        public LoanOne(double amount) {
            this.loanAmount = amount;
        }
    }

    // LoanTwo class
    static class LoanTwo extends Loan {
        public LoanTwo(double amount) {
            this.loanAmount = amount;
        }
    }

    // LoanThree class
    static class LoanThree extends Loan {
        public LoanThree(double amount) {
            this.loanAmount = amount;
        }
    }

    // Student class
    static class Student {
        private int rollNumber;
        private String name;
        private String nationality;
        private int marks;
        private int age;
        private Loan loan;

        public Student(int rollNumber, String name, String nationality, int marks, int age, Loan loan) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.nationality = nationality;
            this.marks = marks;
            this.age = age;
            this.loan = loan;
        }

        public void displayInfo() {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Nationality: " + nationality);
            System.out.println("Marks: " + marks);
            System.out.println("Age: " + age);
            System.out.println("Loan Amount: " + loan.loanAmount);
            System.out.println("Loan Amount After Retention: " + loan.calculateTakeHome());
            System.out.println("Monthly Interest: " + loan.calculateInterestPerMonth());
            System.out.println("Annual Interest: " + loan.calculateInterestPerYear());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[6];
        int studentIndex = 0;

        System.out.println("Welcome to the Loan Management System for Youth Entrepreneurs\n");

        // Loops to input data for each category
        while (studentIndex < 6) {
            System.out.println("\nEnter details for Student " + (studentIndex + 1) + ":");
            int rollNumber = 0, marks = 0, age = 0;
            String name = "", nationality = "";
            double loanAmount = 0.0;

            // Input roll number
            while (true) {
                try {
                    System.out.print("Enter Roll Number: ");
                    rollNumber = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Roll Number.");
                }
            }

            // Input name
            while (true) {
                System.out.print("Enter Name: ");
                name = scanner.nextLine();
                if (!name.isEmpty()) break;
                System.out.println("Name cannot be empty. Please try again.");
            }

            // Input nationality
            while (true) {
                System.out.print("Enter Nationality (East African country): ");
                nationality = scanner.nextLine();
                if (nationality.equalsIgnoreCase("Kenya") ||
                        nationality.equalsIgnoreCase("Uganda") ||
                        nationality.equalsIgnoreCase("Tanzania") ||
                        nationality.equalsIgnoreCase("Rwanda") ||
                        nationality.equalsIgnoreCase("Burundi")) {
                    break;
                }
                System.out.println("Invalid nationality. Only East African nationals are eligible.");
            }

            // Input marks
            while (true) {
                try {
                    System.out.print("Enter Marks (must be 70 or above): ");
                    marks = Integer.parseInt(scanner.nextLine());
                    if (marks >= 70) break;
                    System.out.println("Marks must be 70 or above. Please try again.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Marks.");
                }
            }

            // Input age
            while (true) {
                try {
                    System.out.print("Enter Age (between 18 and 25): ");
                    age = Integer.parseInt(scanner.nextLine());
                    if (age >= 18 && age <= 25) break;
                    System.out.println("Age must be between 18 and 25. Please try again.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Age.");
                }
            }

            // Input loan amount and assign loan category
            Loan loan = null;
            while (true) {
                try {
                    System.out.print("Enter Loan Amount: ");
                    loanAmount = Double.parseDouble(scanner.nextLine());

                    if (studentIndex < 3 && loanAmount >= 5000000 && loanAmount <= 7000000) {
                        loan = new LoanOne(loanAmount);
                        break;
                    } else if (studentIndex >= 3 && studentIndex < 5 && loanAmount >= 4000000 && loanAmount <= 5000000) {
                        loan = new LoanTwo(loanAmount);
                        break;
                    } else if (studentIndex >= 5 && loanAmount >= 1500000 && loanAmount <= 2500000) {
                        loan = new LoanThree(loanAmount);
                        break;
                    } else {
                        System.out.println("Invalid loan amount for this category. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number for Loan Amount.");
                }
            }

            // Create student and add to array
            students[studentIndex] = new Student(rollNumber, name, nationality, marks, age, loan);
            studentIndex++;
        }

        // Display all student information
        System.out.println("\nDisplaying Student Information:\n");
        for (Student student : students) {
            student.displayInfo();
            System.out.println();
        }

        scanner.close();
    }
}