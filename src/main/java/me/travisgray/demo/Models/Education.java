package me.travisgray.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



//
//    @ManyToMany(mappedBy = "educations")
//    private Set<Profile> profiles;

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

    @ManyToMany(mappedBy = "educations",fetch = FetchType.LAZY)
//    @JoinColumn(name="educationofuserid")
    private Set<User> user;

    public Education() {

        user = new HashSet<User>();
    }

    public Education(String degree, String major, String university, String gradyear) {
        this.degree = degree;
        this.major = major;
        this.university = university;
        this.gradyear = gradyear;

    }


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

//    public void addEducation(Education education){
//        education.addEducation(education);
//    }


}
