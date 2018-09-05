/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.imple;

import edu.salle.custommoodle.dataacess.StudentDAO;
import edu.salle.custommoodle.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class StudentDAOListImple implements StudentDAO{
    private static List<Student> studentList = new ArrayList<>();
    @Override
    public Student save(Student student) {
        String Id = Integer.toString(studentList.size()+1);
        student.setId(Id);
        studentList.add(student);
        return student;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student find(String id) {
        for(Student student: studentList){
            if(student.getId().equals(id)){ return student;}
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        List<Student> resStudent = new ArrayList<>();
        lastName = lastName.toLowerCase().trim();
        for(Student student : studentList){
            if(student.getLastName().toLowerCase().contains(lastName)){
                resStudent.add(student);
            }
        }
        return resStudent;
    }

    @Override
    public void delete(Student student) {
        studentList.remove(student);
    }

    @Override
    public void update(Student student) {
        int pos = studentList.lastIndexOf(student);
        studentList.set(pos, student);
    }
    
}
