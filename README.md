# BIT1123 Object Oriented Programming

## Assignment 1 — Individual (20%)

**Student name:** Hamza Gohar  
**Student ID:** 202504010004

## Course information

- **Course code:** BIT1123
- **Course name:** Object Oriented Programming
- **Faculty:** Faculty of Information Technology, City University Malaysia, Cyberjaya Campus
- **Lecturer:** Sir Nazmirul Izzad Bin Nassir
- **Assessment:** Assignment 1, individual, 20%
- **Deadline:** 21 August 2026

## Brief course description

This subject introduces Java and the main ideas of object-oriented programming. Across the weekly tutorials the work moves from a first program and decisions, to classes and objects, inheritance, encapsulation, abstraction, collections, file input and output, and a small Swing interface. The finished tutorials are kept in one repository so the progress is easy to open and run.

## Repository structure

```text
BIT1123-OOP-Assignment1/
├── README.md
├── myreport.pdf
├── week1/
├── week2/
├── week3-4/
├── week5/
├── week6/
├── week7/
├── week8-9/
└── week10/
```

Each week folder holds the `.java` source for that tutorial. Week 5 also has `documentation.txt`. Week 8–9 also has `tasks.txt`, which the program reads and writes.

## Tutorial summary (Week 1 to 10)

### week1

`HelloWorld.java` prints a short introduction with the student name and ID. `StudentGrade.java` reads a name, an ID, and three marks, then prints the average, a letter grade, and a pass or fail result.

### week2

`Student.java` is a class with a constructor and methods. `Main.java` creates two student objects and calls `displayProfile`, `attendClass`, and `submitWork`.

### week3-4

`Person` is the superclass. `Student` and `Lecturer` extend it and override `introduce`. `Main.java` stores both subclasses in a `Person` array so the same method call runs the version that belongs to each object.

### week5

Fields in `Student` are private. Values are changed only through setters, and the CGPA setter rejects a number outside 0.00 to 4.00. `documentation.txt` explains that check.

### week6

`Employee` keeps `staffId`, `name`, and `faculty` as protected fields. `Lecturer` calls `super(...)` and adds the module and room. The child method prints the parent details and then its own.

### week7

`Appliance` is abstract. It supplies `turnOn` and `turnOff`, and leaves `operate` for the subclass. `WashingMachine` and `Refrigerator` each provide their own `operate`. `Main.java` runs both through an `Appliance` array.

### week8-9

Tasks are stored in an `ArrayList`. The menu can add a task, mark one as done, save the list to `tasks.txt`, and load that file again. Reading and writing use `BufferedReader` and `BufferedWriter`, with a try-catch for file errors.

### week10

`CampusQuiz` is a Swing window. `Question` and `QuestionBank` hold the quiz data. Radio buttons and an `ActionListener` check the selected answer, update the score, and move to the next question.

## Technologies used

- Java
- Java Swing (`javax.swing`) for the Week 10 quiz
- Git and GitHub for the repository

## How to run the projects

Install a JDK (Java 8 or newer), then open a terminal in the week folder you want to run.

Week 1:

```text
cd week1
javac HelloWorld.java
java HelloWorld

javac StudentGrade.java
java StudentGrade
```

Weeks 2, 3–4, 5, 6, 7, and 8–9:

```text
cd week2
javac *.java
java Main
```

Use the same two commands inside `week3-4`, `week5`, `week6`, `week7`, or `week8-9`. On Windows PowerShell, if `javac *.java` does not expand, compile the files by name, for example `javac Main.java Student.java`.

Week 10 needs a desktop session because it opens a window:

```text
cd week10
javac *.java
java CampusQuiz
```

Run the Week 8–9 program from inside `week8-9` so it can find `tasks.txt`.

## Reflection summary

The early weeks were about writing a program that compiles and making a class that can be turned into an object. The middle weeks were harder because inheritance, `super`, and private fields change where data lives. File saving in Week 8–9 and the button events in Week 10 took the longest to get right. The full reflection is in `myreport.pdf`.

**GitHub repository URL:** https://github.com/hamzagohar446-svg/BIT1123-OOP-Assignment1
