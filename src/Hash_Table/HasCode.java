package Hash_Table;

import java.util.HashMap;
import java.util.HashSet;

public class HasCode {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "immoc";
        System.out.println(d.hashCode());

        Student1 student1 = new Student1(3,2,"bobo", "liu");
        System.out.println("student1 : " + student1.hashCode());
        Student1 student2 = new Student1(3,2,"bobo", "liu");
        System.out.println("student2 : " + student2.hashCode());

        Student2 student3 = new Student2(3,2,"bobo", "liu");
        System.out.println("student3 : " + student3.hashCode());
        Student2 student4 = new Student2(3,2,"bobo", "liu");
        System.out.println("student4 : " + student4.hashCode());

        //HastSet
        HashSet<Student1> set = new HashSet<>();
        set.add(student1);

        //HashMap
        HashMap<Student1, Integer> score = new HashMap<>();
        score.put(student1, 100);
    }
}
