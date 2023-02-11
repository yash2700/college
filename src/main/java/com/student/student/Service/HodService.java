package com.student.student.Service;

import com.student.student.Enums.BranchName;
import com.student.student.Models.Hod;
import com.student.student.Models.Student;
import com.student.student.Repository.HodRepository;
import com.student.student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HodService {
    @Autowired
    HodRepository hodRepository;
    @Autowired
    private StudentRepository studentRepository;

    public String addHod(Hod hod){
        hodRepository.save(hod);
        return "successfully created";
    }

    public String getHodMobileByMaximumPass(){
        String mobile="";
        List<Hod> hodList=hodRepository.findAll();
        int maximumPassingStudents=0;
        for(Hod hod:hodList){
            int countOfPassingStudents=0;
            for(Student student:hod.getStudentList()){
                if(student.getMarks()>=40){
                    countOfPassingStudents++;
                }
            }
            if(countOfPassingStudents>=maximumPassingStudents){
                maximumPassingStudents=countOfPassingStudents;
                mobile=hod.getContactNo();
            }
        }
        if(mobile.equals("")){
            return "no Hod found";
        }
        else{
            return mobile;
        }
    }

    public Integer getMaximumGrant(){
        List<Student> studentList=studentRepository.findAll();
        int maximumGrant=0;
        String[] branchList={"CS","EE","IT","BT","ME"};
        for(String branch:branchList){
            int grant=0;
            for(Student student:studentList){
                if(student.getMarks()>=40){
                    grant+=100;
                }
            }
            if(grant>=maximumGrant){
                maximumGrant=grant;
            }
        }
        return maximumGrant;
    }

}
