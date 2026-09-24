public class Student {
    String fullName;
    String studentId;
    String programme;
    int semester;

    public Student(String fullName, String studentId, String programme, int semester) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.programme = programme;
        this.semester = semester;
    }

    public void displayProfile() {
        System.out.println("Name       : " + fullName);
        System.out.println("Student ID : " + studentId);
        System.out.println("Programme  : " + programme);
        System.out.println("Semester   : " + semester);
    }

    public void attendClass(String subject) {
        System.out.println(fullName + " is attending " + subject + ".");
    }

    public void submitWork(String title) {
        System.out.println(fullName + " submitted \"" + title + "\".");
    }
}
