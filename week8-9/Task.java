public class Task {
    private String description;
    private boolean done;

    public Task(String description, boolean done) {
        this.description = description;
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        done = true;
    }

    public String toFileLine() {
        return description + "|" + (done ? "DONE" : "OPEN");
    }

    public static Task fromFileLine(String line) {
        int split = line.lastIndexOf('|');
        if (split < 0) {
            return new Task(line, false);
        }
        String description = line.substring(0, split);
        boolean done = line.substring(split + 1).equalsIgnoreCase("DONE");
        return new Task(description, done);
    }

    @Override
    public String toString() {
        return (done ? "[done] " : "[open] ") + description;
    }
}
