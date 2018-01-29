package me.travisgray.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Education() {
    }

    public Education(String degree, String major, String university, int gradyear, ArrayList<Education> educationAbstractList) {
        this.degree = degree;
        this.major = major;
        this.university = university;
        this.gradyear = gradyear;
        this.educationAbstractList = educationAbstractList;
    }


    @ManyToMany
    private Set<Resume> resumes;

    private String degree;
    private String major;
    private String university;
    private int gradyear;

    private ArrayList<Education>educationAbstractList= new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getGradyear() {
        return gradyear;
    }

    public void setGradyear(int gradyear) {
        this.gradyear = gradyear;
    }

    public ArrayList<Education> getEducationAbstractList() {
        return educationAbstractList;
    }

    public void setEducationAbstractList(ArrayList<Education> educationAbstractList) {
        this.educationAbstractList = educationAbstractList;
    }

    public void addEducation(Education education){
        education.addEducation(education);
    }
}
