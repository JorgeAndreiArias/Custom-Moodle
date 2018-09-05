/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.businesslogic;

import edu.salle.custommoodle.dataacess.StudentDAO;
import edu.salle.custommoodle.imple.StudenDAOMySQL;
import edu.salle.custommoodle.imple.StudentDAOListImple;
import edu.salle.custommoodle.model.Student;
import java.util.List;

/**
 *
 */
public class StudentBLO {
    private StudentDAO studentDAO;
    public StudentBLO(){
        studentDAO = new StudentDAOListImple();
        //Tengo mi capa de la vista- se comunica con la capa de negocios, negocio se comunica con DAO
    }
    public Student save(Student student){
        return studentDAO.save(student);
    }
    public List<Student> finAll(){
        return studentDAO.findAll();
    }
    public Student find(String id){
        return studentDAO.find(id);
    }
    
    public Student findByLastName(String lastName){
        return studentDAO.findByLastName(lastName);
    }
    
    public void delete(Student student){
        studentDAO.delete(student);
    }
    
    public void update(Student student){
        studentDAO.update(student);
    }
}
