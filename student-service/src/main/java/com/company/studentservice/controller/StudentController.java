package com.company.studentservice.controller;

import com.company.studentservice.model.Student;
import com.company.studentservice.services.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;


@Api(value = "Student Management System, Operations pertaining to Student in School Management System")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    Environment env;
    private static final Logger log = LogManager.getLogger("mainLogh");

    @Autowired
    StudentService stdService;

    @GetMapping("/")
    @ApiOperation(value = "StudenController Index endpoint",
            notes = "This method returun app name+app-id")
    public String index(){
        log.info("Index endpoint called");
        return env.getProperty("eureka.instance.instance-id");
    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent( @RequestBody Student student){
        return  ResponseEntity.ok(stdService.saveStudent(student));
    }

    @GetMapping("/findbyemail/{email}")
    public Student findByEmail(@PathVariable("email") String email){
        return stdService.findByEmail(email);
    }
    @GetMapping("/greatage/{age}")
    @ApiOperation(value ="This Method return great age from custom Students of age list")
    public Set<Student> studentFilterByAge(@PathVariable("age") Integer age){
        return stdService.studentFilterByAge(age);
    }

    @GetMapping("/delete/{id}")
    @HystrixCommand(fallbackMethod="fallbackDeleteById")
    public Student deleteById(@PathVariable("id") Integer id){
        if(id<5){
            //Test Hystrix
            throw new ArrayIndexOutOfBoundsException();
        }
        Student student=stdService.findById(id);
        stdService.deleteById(id);
        return student;
    }

    private Student fallbackDeleteById(Integer id){
        Student student=new Student();
        student.setName("Bad Request id have to great than 0");
        return student;
    }
}
