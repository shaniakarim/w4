package main;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator {

    public double getAverageGrade(Student student) {
        ArrayList<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }
        return (double) sum / grades.size();
    }

    public double getMedianGrade(Student student) {
        ArrayList<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0;
        }
        ArrayList<Integer> gradeValues = new ArrayList<>();
        for (Grade grade : grades) {
            gradeValues.add(grade.getGrade());
        }
        Collections.sort(gradeValues);
        int middle = gradeValues.size() / 2;
        if (gradeValues.size() % 2 == 1) {
            return gradeValues.get(middle);
        } else {
            return (gradeValues.get(middle - 1) + gradeValues.get(middle)) / 2.0;
        }
    }
}