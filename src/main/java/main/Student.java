package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private final String name;
    private final String studentNumber;
    private final ArrayList<Grade> grades;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.grades = new ArrayList<>();
    }

    public void addGrade(String course, int grade) {
        grades.add(new Grade(course, grade));
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return studentNumber + ": " + name;
    }
}