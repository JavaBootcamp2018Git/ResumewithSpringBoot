package me.travisgray.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profile {

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
    private String references;

    @NotNull
    @NotEmpty
    private String summary;

    private String image;

    @NotNull
    @NotEmpty
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="profileofuserid")
    private Set<User> user;




    public Profile() {

        user = new HashSet<User>();

    }


    public Profile(String firstname, String lastname, String references, String summary, String image, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.references = references;
        this.summary = summary;
        this.image = image;
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
