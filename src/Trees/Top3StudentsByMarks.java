
import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + marks;
    }
}

public class Top3StudentsByMarks {

    public static void main(String[] args) {

        // Student records
        List<Student> students = Arrays.asList(
                new Student("Rahul", 85),
                new Student("Aman", 95),
                new Student("Priya", 90),
                new Student("Rohit", 95),
                new Student("Ankit", 80),
                new Student("Neha", 90)
        );

        // Create a Min Heap of size 3
        PriorityQueue<Student> top3 = new PriorityQueue<>(
                (a, b) -> {
                    int byMarks = Integer.compare(a.marks, b.marks);

                    if (byMarks != 0) {
                        return byMarks;
                    }

                    return b.name.compareTo(a.name);
                }
        );

        // Keep only the top 3 students
        for (Student student : students) {

            top3.offer(student);

            if (top3.size() > 3) {
                top3.poll();
            }
        }

        // Convert heap into a list
        List<Student> result = new ArrayList<>(top3);

        // Sort by marks descending, then name alphabetically
        result.sort(
                Comparator.comparingInt((Student s) -> s.marks)
                        .reversed()
                        .thenComparing(s -> s.name)
        );

        // Display the top 3 students
        System.out.println("Top 3 Students:");

        for (Student student : result) {
            System.out.println(student);
        }
    }
}
