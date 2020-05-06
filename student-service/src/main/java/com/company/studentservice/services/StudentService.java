package com.company.studentservice.services;

import com.company.studentservice.model.Student;
import com.company.studentservice.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository stdRepo;

    public Student saveStudent(Student student){
        return stdRepo.saveAndFlush(student);
    }

    public Student findByEmail(String email){
        return stdRepo.findByEmail(email).orElse(new Student());
    }

    public List<Student> getAll(){
        return stdRepo.findAll();
    }

    public Set<Student> studentFilterByAge(Integer age){
      return   stdRepo.studentFilterByAge(age);
    }

    public void deleteById(int id){
        stdRepo.deleteById(id);
    }

    public Student findById(int id){
        return  stdRepo.findById(id).orElse(new Student());
    }
}
