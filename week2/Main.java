public class Main {
    public static void main(String[] args) {
        Student hamza = new Student("Hamza Gohar", "202504010004", "Information Technology", 1);
        Student amira = new Student("Amira Rahman", "202504010118", "Information Technology", 1);

        System.out.println("=== First student ===");
        hamza.displayProfile();
        hamza.attendClass("Object Oriented Programming");
        hamza.submitWork("Week 2 class exercise");

        System.out.println();
        System.out.println("=== Second student ===");
        amira.displayProfile();
        amira.attendClass("Object Oriented Programming");
    }
}
