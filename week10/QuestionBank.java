import java.util.ArrayList;

public class QuestionBank {
    private ArrayList<Question> questions;

    public QuestionBank() {
        questions = new ArrayList<Question>();
        questions.add(new Question(
                "A class in Java is best described as:",
                new String[] {
                    "A running program in memory",
                    "A blueprint used to create objects",
                    "A file that stores only comments",
                    "A method that returns void"
                },
                1
        ));
        questions.add(new Question(
                "Which keyword creates a new object?",
                new String[] { "class", "extends", "new", "static" },
                2
        ));
        questions.add(new Question(
                "Making fields private and using getters and setters is called:",
                new String[] { "inheritance", "encapsulation", "overloading", "compilation" },
                1
        ));
        questions.add(new Question(
                "Which keyword lets a class reuse another class?",
                new String[] { "implements", "extends", "import", "package" },
                1
        ));
        questions.add(new Question(
                "A subclass replaces a parent method by using:",
                new String[] { "method overriding", "method deleting", "a constructor only", "the final keyword" },
                0
        ));
        questions.add(new Question(
                "An abstract class is useful when:",
                new String[] {
                    "Every method must be static",
                    "Shared behaviour is defined and some methods are left for subclasses",
                    "The class should never have a constructor",
                    "The program has no objects"
                },
                1
        ));
        questions.add(new Question(
                "Which collection grows as items are added?",
                new String[] { "int", "ArrayList", "a fixed array only", "char" },
                1
        ));
        questions.add(new Question(
                "A Swing button click is handled with:",
                new String[] { "ActionListener", "FileReader", "Scanner", "extends Thread only" },
                0
        ));
    }

    public int size() {
        return questions.size();
    }

    public Question get(int index) {
        return questions.get(index);
    }
}
