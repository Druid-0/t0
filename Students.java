import java.util.Scanner;

class Student {
    String name;
    int misd;  // Missed Days
    int mish;  // Missed Hours
    int pris;  // Penalties (Posashenia)

    // Constructor
    public Student(String name, int misd, int mish, int pris) {
        this.name = name;
        this.misd = misd;
        this.mish = mish;
        this.pris = pris;
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Missed Days: " + misd);
        System.out.println("Missed Hours: " + mish);
        System.out.println("Penalties: " + pris);
        System.out.println();
    }
}

// Subclass 'Stud' extending 'Student'
class Stud extends Student {
    String extraInfo;

    // Constructor for 'Stud' subclass
    public Stud(String name, int misd, int mish, int pris, String extraInfo) {
        // Call the constructor of the parent class 'Student'
        super(name, misd, mish, pris);
        this.extraInfo = extraInfo;
    }

    // Overridden method to display extended info
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call the superclass displayInfo method
        System.out.println("Extra Information: " + extraInfo);
    }
}

public class Students {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get input for Student
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter missed days: ");
        int missedDays = sc.nextInt();

        System.out.print("Enter missed hours: ");
        int missedHours = sc.nextInt();

        System.out.print("Enter penalties (posashenia): ");
        int penalties = sc.nextInt();

        // Create a Student object with the entered data
        Student student1 = new Student(studentName, missedDays, missedHours, penalties);
        student1.displayInfo();  // Display Student info

        // To consume the remaining newline character after nextInt()
        sc.nextLine();

        // Get input for Stud (Subclass of Student)
        System.out.print("Enter name for extra info (Stud): ");
        String studName = sc.nextLine();

        System.out.print("Enter missed days for Stud: ");
        int studMissedDays = sc.nextInt();

        System.out.print("Enter missed hours for Stud: ");
        int studMissedHours = sc.nextInt();

        System.out.print("Enter penalties for Stud: ");
        int studPenalties = sc.nextInt();

        // To consume the remaining newline character after nextInt()
        sc.nextLine();

        System.out.print("Enter extra information for Stud: ");
        String extraInfo = sc.nextLine();

        // Create a Stud object with the entered data
        Stud stud1 = new Stud(studName, studMissedDays, studMissedHours, studPenalties, extraInfo);
        stud1.displayInfo();  // Display Stud info

        // Close the scanner to avoid resource leak
        sc.close();
    }
}
