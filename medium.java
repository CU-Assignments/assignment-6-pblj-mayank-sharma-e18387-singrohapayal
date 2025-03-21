import java.util.*;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        // Taking input
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();

            students.add(new Student(id, name, marks));
        }

        // Filtering and sorting students
        List<String> topStudents = students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());

        // Displaying results
        System.out.println("\nStudents scoring above 75%, sorted by marks:");
        topStudents.forEach(System.out::println);
    }
}
