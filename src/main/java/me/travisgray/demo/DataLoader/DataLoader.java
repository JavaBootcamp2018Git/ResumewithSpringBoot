package me.travisgray.demo.DataLoader;

import me.travisgray.demo.Models.Education;
import me.travisgray.demo.Models.Experience;
import me.travisgray.demo.Models.Resume;
import me.travisgray.demo.Models.Skills;
import me.travisgray.demo.Repositories.EducationRepository;
import me.travisgray.demo.Repositories.ExperienceRepository;
import me.travisgray.demo.Repositories.ResumeRepository;
import me.travisgray.demo.Repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    ResumeRepository resumeRepository;


    @Override
    public void run(String...strings)throws Exception{
        Resume resume = new Resume("Travis","Gray","traviosgray1@gmail.com");

        Skills skills1 = new Skills("Java Spring Boot Development","Intermediate");
        skillsRepository.save(skills1);
        Skills skills2 = new Skills("HTML","Advanced");
        skillsRepository.save(skills2);

        Education education1 = new Education("Bachelors of Science","Biobehavioral Health","Penn State","2015");
        educationRepository.save(education1);

        Education education2 = new Education("Bachelors of Science","Biobehavioral Health","Penn State","2015");
        educationRepository.save(education2);


        Experience experience2 = new Experience("Marketing Consultant","Seaton Real Esate","Jan 2010","May 2013","Marketing and Sales");
        experienceRepository.save(experience2);


        Experience experience3 = new Experience("Sales","Mercedes Benz","May 2014","May 2018","Talking with customers");
        experienceRepository.save(experience3);

        resume.addSkills(skills1);
        resume.addSkills(skills2);
        resume.addEducation(education1);
        resume.addEducation(education2);
        resume.addExperience(experience2);
        resume.addExperience(experience3);
        resumeRepository.save(resume);




//
//
    }
}
