public class Lecturer extends Employee {
    private String module;
    private String room;

    public Lecturer(String staffId, String name, String faculty, String module, String room) {
        super(staffId, name, faculty);
        this.module = module;
        this.room = room;
    }

    public void displayTeachingLoad() {
        displayInfo();
        System.out.println("Module   : " + module);
        System.out.println("Room     : " + room);
    }
}
