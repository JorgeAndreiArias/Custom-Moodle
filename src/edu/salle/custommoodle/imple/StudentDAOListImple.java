/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.imple;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.salle.custommoodle.dataacess.StudentDAO;
import edu.salle.custommoodle.model.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
            if(student.getLastName().toLowerCase().contains(lastName) || student.getName().contains(lastName)){
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

    @Override
    public void load() {
        try{
            Gson gson =  new Gson();
            BufferedReader br = new BufferedReader(new FileReader("student.json"));
            studentList = gson.fromJson(br, new TypeToken<List<Student>>(){}.getType());
            if(studentList == null){
                studentList = new ArrayList<>();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    @Override
    public void commitChanges() {
        try{
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("student.json");
            writer.write(gson.toJson(studentList));
            writer.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
