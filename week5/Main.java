public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.setStudentId("202504010004");
        student.setName("Hamza Gohar");
        student.setProgramme("Information Technology");
        student.setCgpa(3.62);

        System.out.println("Student ID : " + student.getStudentId());
        System.out.println("Name       : " + student.getName());
        System.out.println("Programme  : " + student.getProgramme());
        System.out.printf("CGPA       : %.2f%n", student.getCgpa());

        System.out.println();
        System.out.println("Trying an invalid CGPA:");
        student.setCgpa(4.80);
        System.out.printf("CGPA stays : %.2f%n", student.getCgpa());
    }
}
