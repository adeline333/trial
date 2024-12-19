import java.util.Scanner;

public class LoanRequest {
    private String clientName;
    private double salary;
    private double loanAmount;
    private double interestRate = 0.1;  // 10% annually
    private int loanPeriod = 1;  // Loan period in years

    // Constructor
    public LoanRequest() {
        askClientName();
        askSalary();
        askLoanAmount();
        askLoanPeriod();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        // Validate that the name contains only letters and spaces
        if (clientName.matches("[a-zA-Z ]+")) {
            this.clientName = clientName;
        } else {
            System.out.println("Invalid input! Please enter a valid name with only alphabetic characters.");
            // Prompt the user to enter the name again
            askClientName();
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        // Validate salary
        if (salary >= 5000000) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary! The salary must be at least 5,000,000.");
            // Prompt the user to enter the salary again
            askSalary();
        }
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        // Validate loan amount (e.g., no negative amounts)
        if (loanAmount > 0) {
            this.loanAmount = loanAmount;
        } else {
            System.out.println("Invalid loan amount! The amount must be positive.");
            // Prompt the user to enter the loan amount again
            askLoanAmount();
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        // Validate loan period
        if (loanPeriod == 1) {
            this.loanPeriod = loanPeriod;
        } else {
            System.out.println("Invalid loan period! The loan period must be exactly 1 year.");
            // Prompt the user to enter the loan period again
            askLoanPeriod();
        }
    }

    public String seeLoanEligibility() {
        if (this.salary > 5000000 && this.loanPeriod <= 1) {
            return "Loan accepted";
        }
        else {
            return "Loan rejected";
        }
    }

    public double calculateDegressiveInterest() {
        double remainingBalance = loanAmount;
        double totalInterest = 0;

        // Repaying the principal evenly across 12 months
        double monthlyRepayment = loanAmount / 12;

        for (int month = 1; month <= 12; month++) {
            double monthlyInterest = remainingBalance * (interestRate / 12);  // Monthly interest
            totalInterest += monthlyInterest;
            remainingBalance -= monthlyRepayment;  // Subtracting the principal repayment
        }

        double totalRepayment = loanAmount + totalInterest;  // Total loan amount + total interest
        return totalRepayment;
    }

    // Methods to ask for user input directly
    private void askClientName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client name (alphabetical characters only):");
        String name = scanner.nextLine();
        setClientName(name); // Validate and set the client name
    }

    private void askSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter salary (minimum 5,000,000):");
        double salaryInput = scanner.nextDouble();
        setSalary(salaryInput); // Validate and set the salary
    }

    private void askLoanAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter loan amount (positive value):");
        double loanAmountInput = scanner.nextDouble();
        setLoanAmount(loanAmountInput); // Validate and set the loan amount
    }

    private void askLoanPeriod() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter loan period (must be 1 year):");
        int loanPeriodInput = scanner.nextInt();
        setLoanPeriod(loanPeriodInput); // Validate and set the loan period
    }

    public static void main(String[] args) {
        LoanRequest request = new LoanRequest(); // Create a new LoanRequest, prompting user input

        System.out.println(request.seeLoanEligibility());

        double totalRepayment = request.calculateDegressiveInterest();
        System.out.println("Total repayment after 1 year: " + totalRepayment);
    }
}
