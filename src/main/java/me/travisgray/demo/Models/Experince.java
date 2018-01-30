package me.travisgray.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Experince {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public Experince() {
    }



    public Experince(String jobtitle, String companytitle, String startDate, String endDate, String dutylist) {
        this.jobtitle = jobtitle;
        this.companytitle = companytitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dutylist = dutylist;
    }


    @ManyToMany
    private Set<Resume> resumes;

    private String jobtitle;

    private String companytitle;

    private String startDate;

    private String endDate;

    private String dutylist;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getCompanytitle() {
        return companytitle;
    }

    public void setCompanytitle(String companytitle) {
        this.companytitle = companytitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDutylist() {
        return dutylist;
    }

    public void setDutylist(String dutylist) {
        this.dutylist = dutylist;
    }


    public void addExperince(Experince experince){

        experince.addExperince(experince);
    }
}
