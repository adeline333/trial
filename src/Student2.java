
    public class Student2 {
        // Private attributes
        private String name;             // Student name
        private int quizMarks;           // Quiz marks
        private int midTermMarks;        // Midterm marks
        private int finalExamMarks;      // Final exam marks

        // Constructor to initialize the student's attributes
        public Student2(String name, int quizMarks, int midTermMarks, int finalExamMarks) {
            this.name = name;  // Set the student name

            // Validate and set quiz marks
            if (quizMarks >= 0 && quizMarks <= 100) {
                this.quizMarks = quizMarks;
            } else {
                this.quizMarks = 0;  // Set to 0 if invalid
                System.out.println("Invalid quiz marks. Must be between 0 and 100.");
            }

            // Validate and set midterm marks
            if (midTermMarks >= 0 && midTermMarks <= 100) {
                this.midTermMarks = midTermMarks;
            } else {
                this.midTermMarks = 0;  // Set to 0 if invalid
                System.out.println("Invalid midterm marks. Must be between 0 and 100.");
            }

            // Validate and set final exam marks
            if (finalExamMarks >= 0 && finalExamMarks <= 100) {
                this.finalExamMarks = finalExamMarks;
            } else {
                this.finalExamMarks = 0;  // Set to 0 if invalid
                System.out.println("Invalid final exam marks. Must be between 0 and 100.");
            }
        }

        // Getter for student name
        public String getName() {
            return this.name;
        }

        // Setter for student name
        public void setName(String name) {
            this.name = name;
        }

        // Getter for quiz marks
        public int getQuizMarks() {
            return this.quizMarks;
        }

        // Getter for midterm marks
        public int getMidTermMarks() {
            return this.midTermMarks;
        }

        // Getter for final exam marks
        public int getFinalExamMarks() {
            return this.finalExamMarks;
        }

        // Method to calculate total marks out of 20
        public double calculateTotalMarksOutOf20() {
            // Ensure all marks are valid and greater than 0
            if (quizMarks > 0 && midTermMarks > 0 && finalExamMarks > 0) {
                // Calculate total marks out of 20 by summing up marks and dividing by 5
                double totalMarksOutOf20 = (quizMarks + midTermMarks + finalExamMarks) / 5.0;
                return totalMarksOutOf20;
            } else {
                System.out.println("Marks are invalid or missing. Cannot calculate total.");
                return 0;  // Return 0 if marks are invalid or missing
            }
        }

        // Method to print total marks if conditions are met
        public void printTotalMarks() {
            double totalMarksOutOf20 = calculateTotalMarksOutOf20();
            if (totalMarksOutOf20 > 0) {
                System.out.println("Total Marks out of 20: " + totalMarksOutOf20);
            } else {
                System.out.println("Total marks cannot be printed due to invalid conditions.");
            }
        }

        // Main method to test the Student2 class
        public static void main(String[] args) {
            // Create an instance of Student2 with valid marks
            Student2 student = new Student2("John Doe", 85, 75, 90);

            // Print the student's total marks
            student.printTotalMarks();  // Should print the total marks out of 20

            // Create an instance with invalid quiz marks to see validation
            Student2 student2 = new Student2("Jane Doe", 105, 70, 90);  // Invalid quiz marks

            // Print the student's total marks (won't be printed due to invalid marks)
            student2.printTotalMarks();
        }
    }

