package com.company.studentservice.repo;

import com.company.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

     Optional<Student> findByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.age>?1")
    Set<Student> studentFilterByAge(Integer age);


}
