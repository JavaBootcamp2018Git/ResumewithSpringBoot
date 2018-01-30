package me.travisgray.demo.Models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Skills() {

    }

    public Skills(String skill, String skillrating) {
        this.skill = skill;
        this.skillrating = skillrating;
    }

    @ManyToMany
    private Set<Resume>resumes;


    @NotNull
    @NotEmpty
    private String skill;

    @NotNull
    @NotEmpty
    private String skillrating;


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

    public void addSkill(Skills skills){
        skills.addSkill(skills);
    }


}
