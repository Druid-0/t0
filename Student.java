/*import java.util.ArrayList;
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
            System.out.println("Enter details for a new student:");
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Missed Days: ");
            int misd = sc.nextInt();

            System.out.print("Missed Hours: ");
            int mish = sc.nextInt();

            System.out.print("Attendance: ");
            int pris = sc.nextInt();
            sc.nextLine(); // Consume the newline

            // Add the new student to the list
            studentList.add(new Student(name, misd, mish, pris));

            // Ask if the user wants to add another student
            System.out.print("Do you want to add another student? (yes/no): ");
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        // Display all students' information
        System.out.println("\nList of Students:");
        for (Student student : studentList) {
            student.displayInfo();
        }

        sc.close();
    }
}
*/