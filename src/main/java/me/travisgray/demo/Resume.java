package me.travisgray.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstname;
    private String lastname;
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
}
