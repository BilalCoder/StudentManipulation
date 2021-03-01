package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Scanner sc = new Scanner(System.in);
    public static Symposium symposium = new Symposium();
    public static Main m = new Main();
    public static void main(String[] args) {

        int choice = m.getChoice();
        while(choice!=5){
            switch (choice){
                case 1: m.registerStudent();
                break;
                case 2: m.displayAllDetails();
                    break;
                case 3: m.displayOnDept();
                    break;
                case 4: m.displayCountByDept();
                    break;
                case 5: System.exit(0);
            }
            choice = m.getChoice();
        }


    }

    private void displayOnDept() {
        System.out.println("Enter the Department Name: ");
        String dep = sc.next();
        if(dep.equalsIgnoreCase("ece") || dep.equalsIgnoreCase("eee") ||dep.equalsIgnoreCase("cs") || dep.equalsIgnoreCase("it") ) {
            ArrayList<Student> det = symposium.viewStudentInfoByDept(dep);
            if (det.size() == 0) {
                System.out.println("No Students enrolled");
                return;
            } else {
                for (Student student : det) {
                    System.out.println(student.getStudName());
                }
            }
        }
        else
            System.out.println("This Department not eligible for Symposium");

    }

    private void displayAllDetails() {
        ArrayList<Student> st = symposium.viewAllStudentDetails();
        for(Student student : st){
            System.out.println("Student Id:" + student.getStudId());
            System.out.println("Student Name:" + student.getStudName());
            System.out.println("Department Name:" + student.getDeptName());
        }
    }

    private void displayCountByDept() {
        System.out.println("Enter the Department Name:");
        String dep = sc.next();
        System.out.println("Total No of Students:"+symposium.totalStudents(dep));
    }

    private void registerStudent() {
        System.out.println("Enter the Student Id:");
        int id = sc.nextInt();
        System.out.println("Enter the Student name:");
        String name = sc.next();
        System.out.println("Enter the department Name:");
        String depName = sc.next();
        Student student = new Student();
        student.setStudName(name);
        student.setStudId(id);
        student.setDeptName(depName);
        symposium.addStudent(student);
    }

    public int getChoice(){
        System.out.println("1.Register Student\n2.Display all Student Details\n" +
                "3.Display Student Details  based on Department Name\n4.Display total Count of Students – by Department Name\n5.Exit\nEnter your choice:");
        int choice = sc.nextInt();
        return choice;
    }
}
