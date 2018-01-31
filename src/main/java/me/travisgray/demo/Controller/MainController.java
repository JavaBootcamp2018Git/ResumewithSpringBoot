package me.travisgray.demo.Controller;

import me.travisgray.demo.Models.Education;
import me.travisgray.demo.Models.Experince;
import me.travisgray.demo.Models.Resume;
import me.travisgray.demo.Models.Skills;
import me.travisgray.demo.Repositories.EducationRepository;
import me.travisgray.demo.Repositories.ExperinceRepository;
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
    ExperinceRepository experinceRepository;

    @Autowired
    ResumeRepository resumeRepository;


    @RequestMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("getskills", skillsRepository.count());
        model.addAttribute("skilllist", skillsRepository.findAll());
        model.addAttribute("geteducation", educationRepository.count());
        model.addAttribute("educationlist", educationRepository.findAll());
        model.addAttribute("getexperince", experinceRepository.count());
        model.addAttribute("experincelist", experinceRepository.findAll());
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
        Skills skills1 = new Skills();
        model.addAttribute("skill", new Skills());
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

    @GetMapping("/addExperince")
    public String addExperince(Model model) {
        Experince experince = new Experince();
        model.addAttribute("experince", new Experince());
        return "addexperince";
    }

    @PostMapping("/addExperince")
    public String saveExperince(@Valid Experince experince, BindingResult result) {
        {
            if (result.hasErrors()) {
                return "index";
            }
        }
        experinceRepository.save(experince);
        return "addexperince";
    }

//passing all models to method to for thymeleaf access
    @GetMapping("/createResume")
    public String createResume(@ModelAttribute("resume") Resume resume,Model model ){
        model.addAttribute("resume",resumeRepository.findAll());
        return "createresume";


    }






}
