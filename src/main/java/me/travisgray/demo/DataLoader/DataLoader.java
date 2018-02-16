package me.travisgray.demo.DataLoader;

import me.travisgray.demo.Models.*;
import me.travisgray.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public void run(String...strings)throws Exception{

//        DataLoader Resume Test for View
//        Resume resume = new Resume("Travis","Gray","bob the builder","Experince with Real Estate Development and Construction materials","http://sguru.org/wp-content/uploads/2017/06/cool-anonymous-profile-pictures-1699946_orig.jpg","t123@gmail.com");
//        resumeRepository.save(resume);
//
//        Skills skills1 = new Skills("Java Spring Boot Development","Intermediate");
//        skillsRepository.save(skills1);
//
//
//        Education education1 = new Education("Bachelors of Science","Biobehavioral Health","Penn State University","Graduation: 2015");
//        educationRepository.save(education1);
//
//
//
//        Experience experience2 = new Experience("Marketing Consultant","Seaton Real Esate","Jan 2010","May 2013","Marketing and Sales");
//        experienceRepository.save(experience2);
//        System.out.println(experience2.getJobtitle());



//        resume.addSkills(skills1);
//        resume.addEducation(education1);
//        resume.addExperience(experience2);
//        resumeRepository.save(resume);

//        Security Testing

        System.out.println("Loading data...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        // Add user roles
        User user1 = new User("bob@burger.com", "password", "Bobby", "Burger", true, "bob");
        user1.setRoles(Arrays.asList(userRole));
        userRepository.save(user1);



        User user2 = new User("jane@virgin.com", "password", "Jane", "Virgin", true, "jane");
        user2.setRoles(Arrays.asList(userRole));
        userRepository.save(user2);

        // Add admin roles
        User user3 = new User("admin@secure.com", "password", "Admin", "User", true, "admin");
        user3.setRoles(Arrays.asList(adminRole));
        userRepository.save(user3);

        User user4 = new User("clark@kent.com", "password", "Clark", "Kent", true, "clark");
        user4.setRoles(Arrays.asList(userRole, adminRole));
        userRepository.save(user4);

    }
}
