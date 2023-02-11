package com.student.student.Models;

import com.student.student.Enums.BranchName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Hod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;
    private String hodName;

    private String contactNo;

    @OneToMany(mappedBy = "hod",cascade = CascadeType.ALL)
    private List<Student> studentList;

    public Hod() {
    }

    public Hod(int id, BranchName branchName, String hodName, String contactNo, List<Student> studentList) {
        this.id = id;
        this.branchName = branchName;
        this.hodName = hodName;
        this.contactNo = contactNo;
        this.studentList = studentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BranchName getBranchName() {
        return branchName;
    }

    public void setBranchName(BranchName branchName) {
        this.branchName = branchName;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
