package me.travisgray.demo.DataLoader;

import me.travisgray.demo.Models.*;
import me.travisgray.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JobRepository jobRepository;


    @Override
    public void run(String...strings)throws Exception{

        //        Security Testing in database

        System.out.println("Loading data...");

        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("RECRUITER"));
        roleRepository.save(new Role("JOBSEEKER"));



        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");
        Role recruiterRole = roleRepository.findByRole("RECRUITER");
        Role jobseekerRole = roleRepository.findByRole("JOBSEEKER");



        User recruiterrole1 =  new User("rec@virgin.com", "password", "recfirst", "reclast", true, "rec1");
        recruiterrole1.setRoles(Arrays.asList(recruiterRole));
        userRepository.save(recruiterrole1);


        User jobseekerrole1 = new User("job@virgin.com", "password", "jobfirst", "joblast", true, "job1");
        jobseekerrole1.setRoles(Arrays.asList(jobseekerRole));
        userRepository.save(jobseekerrole1);


        // Add user roles
        User user1 = new User("bob@burger.com", "password", "Bobby", "Burger", true, "bob");
        user1.setRoles(Arrays.asList(userRole));
        userRepository.save(user1);
//
//
//
        User user2 = new User("jane@virgin.com", "password", "Jane", "Virgin", true, "jane");
        user2.setRoles(Arrays.asList(userRole));
        userRepository.save(user2);

        // Add admin roles
        User user3 = new User("admin@secure.com", "password", "Admin", "User", true, "admin");
        user3.setRoles(Arrays.asList(adminRole));
        userRepository.save(user3);
//
        User user4 = new User("clark@kent.com", "password", "Clark", "Kent", true, "clark");
        user4.setRoles(Arrays.asList(userRole, adminRole));
        userRepository.save(user4);

//        DataLoader Profile Test for View
        Profile resume = new Profile("Travis","Gray","bob the builder","Experince with Real Estate Development and Construction materials","http://sguru.org/wp-content/uploads/2017/06/cool-anonymous-profile-pictures-1699946_orig.jpg","t123@gmail.com");
        profileRepository.save(resume);

        Skills skills1 = new Skills("Java Spring Boot Development","Intermediate");
        skillsRepository.save(skills1);


        Education education1 = new Education("Bachelors of Science","Biobehavioral Health","Penn State University","Graduation: 2015");
        educationRepository.save(education1);


        Education education2 = new Education("Bachelors of Science","Biobehavioral Health","Penn State University","Graduation: 2015");
        educationRepository.save(education2);




        Experience experience2 = new Experience("Marketing Consultant","Seaton Real Esate","Jan 2010","May 2013","Marketing and Sales");
        experienceRepository.save(experience2);
        System.out.println(experience2.getJobtitle());

        Job job1 = new Job("Montgormery College", "Java Coach","Teacher","$60,000");
        jobRepository.save(job1);
        System.out.println(job1.getSkills());


        user1.addEducation(education1);
        userRepository.save(user1);


        user2.addExperience(experience2);
        userRepository.save(user2);


        user3.addSkill(skills1);
        userRepository.save(user3);


        job1.addskilltojob(skills1);
        jobRepository.save(job1);
    }
}
