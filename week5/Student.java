public class Student {
    private String studentId;
    private String name;
    private double cgpa;
    private String programme;

    public void setStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Student ID cannot be empty.");
            return;
        }
        this.studentId = studentId.trim();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        this.name = name.trim();
    }

    public void setCgpa(double cgpa) {
        if (cgpa < 0.0 || cgpa > 4.0) {
            System.out.println("CGPA must be between 0.00 and 4.00.");
            return;
        }
        this.cgpa = cgpa;
    }

    public void setProgramme(String programme) {
        if (programme == null || programme.trim().isEmpty()) {
            System.out.println("Programme cannot be empty.");
            return;
        }
        this.programme = programme.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getProgramme() {
        return programme;
    }
}
