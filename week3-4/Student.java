public class Student extends Person {
    private String programme;
    private int year;

    public Student(String name, String id, String programme, int year) {
        super(name, id);
        this.programme = programme;
        this.year = year;
    }

    public String getProgramme() {
        return programme;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void introduce() {
        System.out.println("Student " + getName() + " is in year " + year + " of " + programme + ".");
    }

    public void study(String topic) {
        System.out.println(getName() + " is revising " + topic + ".");
    }
}
