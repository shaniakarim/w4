package main;

public class Grade {
    private final String course;
    private final int grade;

    public Grade(String course, int grade) {
        this.course = course;
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return course + ": " + grade;
    }
}