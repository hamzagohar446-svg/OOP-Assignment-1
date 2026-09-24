public class Main {
    public static void main(String[] args) {
        Student student = new Student(
                "Hamza Gohar",
                "202504010004",
                "Information Technology",
                1
        );
        Lecturer lecturer = new Lecturer(
                "Nazmirul Izzad",
                "LEC-BIT1123",
                "Faculty of Information Technology",
                "Object Oriented Programming"
        );
        Person visitor = new Person("Campus Visitor", "VIS-01");

        System.out.println("=== Direct calls ===");
        student.introduce();
        student.study("inheritance");
        lecturer.introduce();
        lecturer.conductClass();

        System.out.println();
        System.out.println("=== Polymorphism ===");
        Person[] people = { visitor, student, lecturer };
        for (Person person : people) {
            person.introduce();
        }
    }
}
