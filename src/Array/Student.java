package Array;

public class Student {
    private String name;
    private int score;

    public Student(String studentname, int studentscore) {
        name = studentname;
        score = studentscore;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d", name, score);
    }

    public static void main(String[] agrs) {
        Array<Student> arr = new Array<Student>();
        arr.addLast(new Student("Alice", 100));
        arr.addLast(new Student("Bob", 66));
        arr.addLast(new Student("Cherry", 80));
        System.out.println(arr);
    }
}
