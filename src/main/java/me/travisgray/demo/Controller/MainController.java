package me.travisgray.demo.Controller;

import me.travisgray.demo.Models.Education;
import me.travisgray.demo.Models.Experience;
import me.travisgray.demo.Models.Resume;
import me.travisgray.demo.Models.Skills;
import me.travisgray.demo.Repositories.EducationRepository;
import me.travisgray.demo.Repositories.ExperienceRepository;
import me.travisgray.demo.Repositories.ResumeRepository;
import me.travisgray.demo.Repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    ResumeRepository resumeRepository;


    @RequestMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("getskills", skillsRepository.count());
        model.addAttribute("skilllist", skillsRepository.findAll());
        model.addAttribute("geteducation", educationRepository.count());
        model.addAttribute("educationlist", educationRepository.findAll());
        model.addAttribute("getexperince", experienceRepository.count());
        model.addAttribute("experincelist", experienceRepository.findAll());
        model.addAttribute("resume", resumeRepository.count());
        model.addAttribute("resumelist", resumeRepository.findAll());
        return "index";

    }

    @GetMapping("/addResume")
    public String addResume(Model model) {
        //Creating Resume model for new form
        Resume resume = new Resume();
        model.addAttribute("resume", new Resume());
        return "addresume";
    }


    //Process and save Resume form Binding Result nesscary for Thymeleaf Valaidation
    @PostMapping("/addResume")
    public String saveResume(@Valid Resume resume, BindingResult result) {
        {
            if (result.hasErrors()) {
                return "index";

            }

            resumeRepository.save(resume);
            return "addresume";
        }
    }

    @GetMapping("/addSkill")
    public String addSkill(Model model) {
        Skills skills = new Skills();
        model.addAttribute("skills", new Skills());
        return "addskill";
    }

    @PostMapping("/addSkill")
    public String saveSkill(@Valid Skills skill, BindingResult result) {

        {
            if (result.hasErrors()) {
                return "index";
            }

            skillsRepository.save(skill);
            return "addskill";
        }
    }

    @GetMapping("/addEducation")
    public String addEducation(Model model) {
        Education education = new Education();
        model.addAttribute("education", new Education());
        return "addeducation";
    }

    @PostMapping("/addEducation")
    public String saveEducation(@Valid Education education, BindingResult result) {

        {
            if (result.hasErrors()) {
                return "index";

            }

            educationRepository.save(education);
            return "addeducation";
        }
    }

    @GetMapping("/addExperience")
    public String addExperience(Model model) {
        Experience experience = new Experience();
        model.addAttribute("experience", new Experience());
        return "addexperience";
    }

    @PostMapping("/addExperience")
    public String saveExperience(@Valid Experience experience, BindingResult result) {
        {
            if (result.hasErrors()) {
                return "index";
            }
        }
        experienceRepository.save(experience);
        return "addexperience";
    }

//passing all models to method to for thymeleaf access
    //Passing in all models and finding id of resume then adding that model back into Thymeleaf for template access
    @GetMapping("/createResume")
    public String createResume(Model model){
        Resume resume = resumeRepository.findOne(Long.valueOf(1));
        System.out.println("Printing whats in resume"+resume.getExperiences()+resume.getEducations()+resume.getSkills());
        model.addAttribute("resume",resume);
        return "createresume";


    }






}
