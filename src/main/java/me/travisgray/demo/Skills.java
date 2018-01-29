package me.travisgray.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Skills() {


    }

    public Skills(ArrayList<Skills> skillsArrayList, String skill, String skillrating) {
        this.skillsArrayList = skillsArrayList;
        this.skill = skill;
        this.skillrating = skillrating;
    }



    @ManyToMany
    private Set<Resume>resumes;





    private ArrayList<Skills>skillsArrayList = new ArrayList<>();
    private String skill;
    private String skillrating;


    public ArrayList<Skills> getSkillsArrayList() {
        return skillsArrayList;
    }

    public void setSkillsArrayList(ArrayList<Skills> skillsArrayList) {
        this.skillsArrayList = skillsArrayList;
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

    public void addSkill(Skills skills){
        skills.addSkill(skills);
    }


}
