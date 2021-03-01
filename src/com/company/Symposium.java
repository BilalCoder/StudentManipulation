package com.company;

import java.util.ArrayList;

public class Symposium {

    private ArrayList<Student> studentList=new ArrayList<Student>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student aobj){
        studentList.add(aobj);
    }

    public boolean isEmpty(){
        if(studentList.size()==0)
            return true;
        return false;
    }

    public ArrayList<Student> viewAllStudentDetails(){
        return studentList;
    }

    public ArrayList<Student> viewStudentInfoByDept(String deptName){
        ArrayList al = new ArrayList();
        for(Student student : studentList){
            if(student.getDeptName().equalsIgnoreCase(deptName))
                al.add(student);
        }
        return al;
    }

    public int totalStudents(String deptName){
        return viewStudentInfoByDept(deptName).size();
    }
}
