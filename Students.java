import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    String name;
    int misd; // Missed Days
    int mish; // Missed Hours
    int pris; // Attendance

    public Student(String name, int misd, int mish, int pris) {
        this.name = name;
        this.misd = misd;
        this.mish = mish;
        this.pris = pris;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Missed Days: " + misd);
        System.out.println("Missed Hours: " + mish);
        System.out.println("Attendance: " + pris);
        System.out.println();
    }
}

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\nEnter details for a new student:");
                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Missed Days: ");
                int misd = sc.nextInt();
                if (misd < 0) throw new IllegalArgumentException("Missed days cannot be negative");

                System.out.print("Missed Hours: ");
                int mish = sc.nextInt();
                if (mish < 0) throw new IllegalArgumentException("Missed hours cannot be negative");

                System.out.print("Attendance: ");
                int pris = sc.nextInt();
                if (pris < 0) throw new IllegalArgumentException("Attendance cannot be negative");
                
                sc.nextLine(); // Consume the newline

                studentList.add(new Student(name, misd, mish, pris));

                System.out.print("Do you want to add another student? (yes/no): ");
                String response = sc.nextLine();
                if (response.equalsIgnoreCase("no")) {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter valid numbers for numerical fields");
                sc.nextLine(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again");
                sc.nextLine(); // Clear the invalid input
            }
        }

        System.out.println("\n=== List of Students ===");
        for (Student student : studentList) {
            student.displayInfo();
        }

        sc.close();
    }
}
