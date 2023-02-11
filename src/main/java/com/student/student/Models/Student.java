package com.student.student.Models;

import com.student.student.Enums.BranchName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rollNo;

    private int year;
    private  String name;
    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BranchName getBranchName() {
        return branchName;
    }

    public void setBranchName(BranchName branchName) {
        this.branchName = branchName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getGrant() {
        return grant;
    }

    public void setGrant(int grant) {
        this.grant = grant;
    }

    public Hod getHod() {
        return hod;
    }

    public void setHod(Hod hod) {
        this.hod = hod;
    }

    public Student( String rollNo, int year, String name, BranchName branchName, int marks, int grant, Hod hod) {

        this.rollNo = rollNo;
        this.year = year;
        this.name = name;
        this.branchName = branchName;
        this.marks = marks;
        this.grant = grant;
        this.hod = hod;
    }

    private int marks;

    private int grant;

    @ManyToOne
    @JoinColumn
    private Hod hod;
}
