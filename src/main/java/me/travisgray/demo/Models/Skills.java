package me.travisgray.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @ManyToMany(mappedBy = "skills")
//    private Set<Profile> profiles;

@ManyToMany(fetch = FetchType.EAGER)
private Set<User> user;

@ManyToMany(mappedBy = "skills" ,fetch = FetchType.EAGER)
private Set<Job>jobs;


    @NotNull
    @NotEmpty
    private String skill;

    @NotNull
    @NotEmpty
    private String skillrating;

    public Skills() {

        user = new HashSet<User>();
        jobs = new HashSet<Job>();
    }

    public void addUser(User u){
        this.user.add(u);
    }


    public Skills(String skill, String skillrating) {
        this.skill = skill;
        this.skillrating = skillrating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSkillrating() {
        return skillrating;
    }

    public void setSkillrating(String skillrating) {
        this.skillrating = skillrating;
    }

//    public void addResume(Profile r){
//       this.profiles.add(r);
//    }


//    public Set<Profile> getProfiles() {
//        return profiles;
//    }
//
//    public void setProfiles(Set<Profile> profiles) {
//        this.profiles = profiles;
//    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}
