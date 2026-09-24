public class Lecturer extends Person {
    private String faculty;
    private String module;

    public Lecturer(String name, String id, String faculty, String module) {
        super(name, id);
        this.faculty = faculty;
        this.module = module;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getModule() {
        return module;
    }

    @Override
    public void introduce() {
        System.out.println("Lecturer " + getName() + " teaches " + module + " in " + faculty + ".");
    }

    public void conductClass() {
        System.out.println(getName() + " is conducting the " + module + " class.");
    }
}
