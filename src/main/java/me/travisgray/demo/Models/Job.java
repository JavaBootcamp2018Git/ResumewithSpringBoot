package me.travisgray.demo.Models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private String employer;

    private String title;

    private String description;

    private String salary;


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Skills>skills;

    public Job(String employer, String title, String description, String salary) {
        this.employer = employer;
        this.title = title;
        this.description = description;
        this.salary = salary;
        skills = new HashSet<Skills>();

    }

    public Job() {

        skills = new HashSet<Skills>();
    }

    public void addskilltojob (Skills s){
        this.skills.add(s);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }
}
