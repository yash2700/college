package com.student.student.Service;

import com.student.student.Models.Hod;
import com.student.student.Models.Student;
import com.student.student.Repository.HodRepository;
import com.student.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    HodRepository hodRepository;

    public String addStudent(Student student){
        Hod hod=hodRepository.findByBranchName(student.getBranchName());
        hod.getStudentList().add(student);
        student.setHod(hod);
        if(student.getMarks()>=40){
            student.setGrant(100);
        }
        studentRepository.save(student);
        hodRepository.save(hod);
        return "Successfully created";
    }

    public List<String> getByRecentYear(){
        List<Student> studentList=studentRepository.findAll();
        List<String> resultList=new ArrayList<>();
        for(Student student:studentList){
            if(student.getYear()== Calendar.getInstance().get(Calendar.YEAR)){
                resultList.add(student.getRollNo());
            }
        }
        return resultList;
    }
}
