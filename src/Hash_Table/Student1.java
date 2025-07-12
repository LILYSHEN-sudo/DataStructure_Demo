package Hash_Table;

public class Student1 {
    int grade;
    int cls;
    String firstname;
    String lastname;

    Student1(int grade, int cls, String firstname, String lastname) {
        this.grade = grade;
        this.cls = cls;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + firstname.toLowerCase().hashCode();
        hash = hash * B + lastname.toLowerCase().hashCode();
        return hash;
    }
}
