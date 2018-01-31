package me.travisgray.demo.DataLoader;

import me.travisgray.demo.Models.Education;
import me.travisgray.demo.Models.Experince;
import me.travisgray.demo.Models.Resume;
import me.travisgray.demo.Models.Skills;
import me.travisgray.demo.Repositories.EducationRepository;
import me.travisgray.demo.Repositories.ExperinceRepository;
import me.travisgray.demo.Repositories.ResumeRepository;
import me.travisgray.demo.Repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperinceRepository experinceRepository;

    @Autowired
    ResumeRepository resumeRepository;


    @Override
    public void run(String...strings)throws Exception{
        Resume resume = new Resume("Travis","Gray","traviosgray1@gmail.com");

        Skills skills1 = new Skills("Java Spring Boot Development","Intermediate");
        skillsRepository.save(skills1);
        Skills skills2 = new Skills("HTML","Advanced");
        skillsRepository.save(skills2);



        resume.addSkills(skills1);
        resumeRepository.save(resume);



//        Skills skills2 = new Skills("HTML","Advanced");
//        skillsRepository.save(skills2);
//        resume.addSkills(skills2);
//        resumeRepository.save(resume);

//        Education education = new Education("Bachelors of Science","Biobehavioral Health","Penn State",2015);
//        educationRepository.save(education);
//
//
//        Experince experince = new Experince("Marketing Consultant","Seaton Real Esate","Jan 2010","May 2013","Marketing and Sales");
//        experinceRepository.save(experince);
    }
}
