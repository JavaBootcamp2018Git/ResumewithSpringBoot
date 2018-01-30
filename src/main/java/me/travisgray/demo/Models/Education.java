package me.travisgray.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Education() {
    }

    public Education(String degree, String major, String university, String gradyear) {
        this.degree = degree;
        this.major = major;
        this.university = university;
        this.gradyear = gradyear;
    }


    @ManyToMany
    private Set<Resume> resumes;

    @NotNull
    @NotEmpty
    private String degree;

    @NotNull
    @NotEmpty
    private String major;

    @NotNull
    @NotEmpty
    private String university;

    @NotEmpty
    @NotNull
    private String gradyear;

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

    public String getGradyear() {
        return gradyear;
    }

    public void setGradyear(String gradyear) {
        this.gradyear = gradyear;
    }

    public void addEducation(Education education){
        education.addEducation(education);
    }


}
