package main;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("1) Add student, 2) List students, 3) Add course completion for student, 4) List course completions of student, 5) Calculate the average of course completions, 6) Calculate median of course completions, 7) Save students to file, 8) Load students from file, 0) End the program");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("What is the name of the student?");
                    String name = scanner.nextLine();
                    System.out.println("What is the student number of the student?");
                    String studentNumber = scanner.nextLine();
                    university.addStudent(new Student(name, studentNumber));
                }
                case "2" -> {
                    System.out.println("Students:");
                    for (Student student : university.getStudents()) {
                        System.out.println(student);
                    }
                }
                case "3" -> {
                    System.out.println("Which student do you want to add course completion for?");
                    listStudents(university);
                    int studentIndex = Integer.parseInt(scanner.nextLine());
                    if (studentIndex < 0 || studentIndex >= university.getStudents().size()) {
                        System.out.println("Wrong input value");
                        break;
                    }
                    Student selectedStudent = university.getStudents().get(studentIndex);
                    System.out.println("What is the name of the course?");
                    String course = scanner.nextLine();
                    System.out.println("What is the grade of the course?");
                    int grade = Integer.parseInt(scanner.nextLine());
                    selectedStudent.addGrade(course, grade);
                }
                case "4" -> {
                    System.out.println("Which student do you want to list course completions for?");
                    listStudents(university);
                    int studentIndex = Integer.parseInt(scanner.nextLine());
                    if (studentIndex < 0 || studentIndex >= university.getStudents().size()) {
                        System.out.println("Wrong input value");
                        break;
                    }
                    Student selectedStudent = university.getStudents().get(studentIndex);
                    for (Grade g : selectedStudent.getGrades()) {
                        System.out.println(g);
                    }
                }
                case "5" -> {
                    System.out.println("Which student do you want to calculate the average for?");
                    listStudents(university);
                    int studentIndex = Integer.parseInt(scanner.nextLine());
                    if (studentIndex < 0 || studentIndex >= university.getStudents().size()) {
                        System.out.println("Wrong input value");
                        break;
                    }
                    Student selectedStudent = university.getStudents().get(studentIndex);
                    System.out.println("Average is " + calculator.getAverageGrade(selectedStudent));
                }
                case "6" -> {
                    System.out.println("Which student do you want to calculate the median for?");
                    listStudents(university);
                    int studentIndex = Integer.parseInt(scanner.nextLine());
                    if (studentIndex < 0 || studentIndex >= university.getStudents().size()) {
                        System.out.println("Wrong input value");
                        break;
                    }
                    Student selectedStudent = university.getStudents().get(studentIndex);
                    System.out.println("Median is " + calculator.getMedianGrade(selectedStudent));
                }
                case "7" -> {
                    System.out.println("Enter filename to save:");
                    String filename = scanner.nextLine();
                    try {
                        university.saveToFile(filename);
                    } catch (IOException e) {
                        System.out.println("Error saving to file");
                    }
                }
                case "8" -> {
                    System.out.println("Enter filename to load:");
                    String filename = scanner.nextLine();
                    try {
                        university.loadFromFile(filename);
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error loading from file");
                    }
                }
                case "0" -> {
                    System.out.println("Thank you for using the program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Wrong input value");
            }
        }
    }

    private static void listStudents(University university) {
        int i = 0;
        for (Student student : university.getStudents()) {
            System.out.println(i + ": " + student);
            i++;
        }
    }
}