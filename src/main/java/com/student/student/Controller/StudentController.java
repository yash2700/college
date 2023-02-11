package com.student.student.Controller;

import com.student.student.Models.Student;
import com.student.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody()Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/getByRecentYear")
    public ResponseEntity<List<String>> getByRecentYear(){
        return new ResponseEntity<>(studentService.getByRecentYear(),HttpStatus.FOUND);
    }
}
