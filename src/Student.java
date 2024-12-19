public class Student {
    // Private attributes for student details and marks
    private String studentName;      // Name of the student
    private int quizMarks;           // Quiz marks
    private int midtermMarks;        // Midterm marks
    private int finalExamMarks;      // Final exam marks
    private String studentID;        // Student ID

    // Constructor to initialize attributes with validation
    public Student(String studentName, String studentID, int quizMarks, int midtermMarks, int finalExamMarks) {
        this.studentName = studentName;   // Set student name
        this.studentID = studentID;       // Set student ID

        // Validate marks: Only accept valid marks (between 0 and 100)
        if (quizMarks >= 0 && quizMarks <= 100) {
            this.quizMarks = quizMarks;
        } else {
            this.quizMarks = 0;  // Default to 0 if invalid
            System.out.println("Invalid quiz marks. Set to 0.");
        }

        if (midtermMarks >= 0 && midtermMarks <= 100) {
            this.midtermMarks = midtermMarks;
        } else {
            this.midtermMarks = 0;  // Default to 0 if invalid
            System.out.println("Invalid midterm marks. Set to 0.");
        }

        if (finalExamMarks >= 0 && finalExamMarks <= 100) {
            this.finalExamMarks = finalExamMarks;
        } else {
            this.finalExamMarks = 0;  // Default to 0 if invalid
            System.out.println("Invalid final exam marks. Set to 0.");
        }
    }

    // Method to calculate total marks (out of 100)
    public int calculateTotalMarks() {
        // Don't calculate if midterm or final is missing (zero)
        if (midtermMarks == 0 || finalExamMarks == 0) {
            System.out.println("Missing midterm or final exam marks. Total not calculated.");
            return 0;
        }
        return quizMarks + midtermMarks + finalExamMarks;  // Sum up the marks
    }

    // Method to calculate average marks (out of 20)
    public double calculateAverageMarks() {
        int totalMarks = calculateTotalMarks();
        return (totalMarks > 0) ? totalMarks / 5.0 : 0;  // Only calculate if total is valid
    }

    // Method to print student details
    public void printStudentDetails() {
        // Don't print details if quiz was not attempted
        if (quizMarks == 0) {
            System.out.println(studentName + " did not attempt the quiz.");
            return;
        }

        // Print basic details
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);

        // Calculate and print total and average marks
        int totalMarks = calculateTotalMarks();
        if (totalMarks > 0) {
            System.out.println("Total Marks (out of 100): " + totalMarks);
            System.out.println("Average Marks (out of 20): " + calculateAverageMarks());
        }
    }

    // Main method to test
    public static void main(String[] args) {
        // Example students with test cases
        Student student1 = new Student("Alice", "S123", 85, 70, 90);  // Valid marks
        student1.printStudentDetails();

        Student student2 = new Student("Bob", "S124", 0, 80, 75);    // Quiz not attempted
        student2.printStudentDetails();

        Student student3 = new Student("Charlie", "S125", 75, 0, 88); // Midterm missing
        student3.printStudentDetails();
    }
}
