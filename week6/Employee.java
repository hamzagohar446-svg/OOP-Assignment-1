public class Employee {
    protected String staffId;
    protected String name;
    protected String faculty;

    public Employee(String staffId, String name, String faculty) {
        this.staffId = staffId;
        this.name = name;
        this.faculty = faculty;
    }

    public void displayInfo() {
        System.out.println("Staff ID : " + staffId);
        System.out.println("Name     : " + name);
        System.out.println("Faculty  : " + faculty);
    }
}
