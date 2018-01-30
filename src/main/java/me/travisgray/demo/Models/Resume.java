package me.travisgray.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.ui.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotEmpty
    private String firstname;

    @NotNull
    @NotEmpty
    private String lastname;

    @NotNull
    @NotEmpty
    private String email;


    @ManyToMany(mappedBy = "resumes")
    private Set<Skills> skills;

    @ManyToMany(mappedBy = "resumes")
    private Set<Experince>experinces;

    @ManyToMany(mappedBy = "resumes")
    private Set<Education>educations;

    public Resume() {

    }

    public Resume(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addResume(Resume resume){
        resume.addResume(resume);
    }

//    public void addSkills(Skills skills){
//        skills.addSkill(skills);
//    }
//
//    public void addEducation(Education education){
//        education.addEducation(education);   }
//
//    public void addExperince(Experince experince){
//        experince.addExperince(experince);
//    }
}
