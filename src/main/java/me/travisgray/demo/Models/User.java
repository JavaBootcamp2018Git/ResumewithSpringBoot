package me.travisgray.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name="USER_DATA")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="username")
    private String username;


    @Column(name="references")
    private String references;

    @Column(name="summary")
    private String summary;

    @Column(name="image")
    private String image;


    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Skills> skills;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Experience>experiences;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Education> educations;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private Collection<Role> roles;

    public User() {

        educations = new HashSet<Education>();
        skills = new HashSet<Skills>();
        experiences = new HashSet<Experience>();
        roles = new HashSet<Role>();
    }


    public User(String email, String password, String firstName, String lastName, boolean enabled, String username, String references, String summary, String image) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.username = username;
        this.references = references;
        this.summary = summary;
        this.image = image;
        educations = new HashSet<Education>();
        skills = new HashSet<Skills>();
        experiences = new HashSet<Experience>();
        roles = new HashSet<Role>();
    }

    public void addEducation(Education e){
           this.educations.add(e);
    }

    public void addSkill(Skills s){
        this.skills.add(s);
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


    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
