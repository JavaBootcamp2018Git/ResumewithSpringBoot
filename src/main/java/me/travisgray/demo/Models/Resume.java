package me.travisgray.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotNull
    @NotEmpty
    private String firstname;

    @NotNull
    @NotEmpty
    private String lastname;

    @NotNull
    @NotEmpty
    private String email;

    @ManyToMany()
    public Set<Skills> skills;

    @ManyToMany()
    public Set<Experience>experiences;

    @ManyToMany()
    public Set<Education>educations;

    public Resume() {

    }

    public Resume(Set<Skills> skills , Set<Education>educations,Set<Experience>experience) {
        this.skills = new HashSet<Skills>();
        this.experiences = new HashSet<Experience>();
        this.educations = new HashSet<Education>();

    }

    public Resume(String firstname, String lastname, String email) {
        this.skills = new HashSet<Skills>();
        this.educations = new HashSet<Education>();
        this.experiences = new HashSet<Experience>();
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

    public void addSkills(Skills s) {
        this.skills.add(s);
    }

    public void addEducation(Education e){
        this.educations.add(e);
    }

    public void addExperience(Experience ex){
        this.experiences.add(ex);
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }
}
