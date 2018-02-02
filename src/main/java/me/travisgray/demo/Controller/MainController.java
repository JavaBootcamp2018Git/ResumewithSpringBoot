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

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/addResume")
    public String addResume(Model model) {
        //Creating Resume model for new form
        Resume resume = new Resume();
        model.addAttribute("resume", new Resume());
        return "addresume";
    }

//    Find ID from resume the return to indexpage so that it see the id use path variable to make sure id is passed then return to index then whenn going to create reume route loop through
//    Try this on on class to start then move into other collections

    @RequestMapping("/")
    public String showIndex(Model model) {
//        model.addAttribute("getskills", skillsRepository.count());
//        model.addAttribute("skilllist", skillsRepository.findAll());
//        model.addAttribute("geteducation", educationRepository.count());
//        model.addAttribute("educationlist", educationRepository.findAll());
//        model.addAttribute("getexperince", experienceRepository.count());
//        model.addAttribute("experincelist", experienceRepository.findAll());
//        model.addAttribute("resume", resumeRepository.count());
        model.addAttribute("resumelist", resumeRepository.findAll());
        return "index";

    }



    //Process and save Resume form Binding Result nesscary for Thymeleaf Valaidation
    @PostMapping("/addResume")
    public String saveResume(@Valid Resume resume, BindingResult result) {
        {
            if (result.hasErrors()) {
                return "addresume";


            }

            resumeRepository.save(resume);
            return "redirect:/";
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
                return "addskill";
            }

            skillsRepository.save(skill);
            return "redirect:/";
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
                return "addeducation";


            }

            educationRepository.save(education);
            System.out.println(educationRepository.toString());
            System.out.println(education.getGradyear()+education.getDegree()+education.getMajor()+education.getUniversity()+education.getId());
            return "redirect:/";
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
                return "addexperience";
            }
        }

        experienceRepository.save(experience);
        System.out.println(experienceRepository.toString());
        System.out.println(experience.getJobtitle()+experience.getCompanytitle()+experience.getJobtitle()+experience.getStartDate()+experience.getEndDate());
        return "redirect:/";
    }

//passing all models to method to for thymeleaf access
    //Passing in all models and finding id of resume then adding that model back into Thymeleaf for template access need to add {id} to end of this Post rout ex: createResume/{id}
//    Most be Post Mapping to get id

    //Get mapping displays html form properly with dataloader entries
    @GetMapping("/createResume")
    public String createResume(HttpServletRequest request,Model model){

//

//        Binding a Model(Object Resumeid ) to parameter passed by button in "index" line 17 in header
//        Saving resume model id from parameter to resume repo before adding model attribute
        Resume resume = resumeRepository.findOne( new Long (request.getParameter("id")));
        model.addAttribute("resume",resume);



//        Testing for Thymeleaf model code for final resume output
        //Getting Resume id containing all attributes


//        resume = resumeRepository.findOne(Long.valueOf(1));
//        for (Experience eachexperience: resume.experiences){
//            System.out.println(eachexperience.getJobtitle());
//        }
//
//        for (Skills eachskill: resume.skills){
//            System.out.println(eachskill.getSkill());
//            System.out.println(eachskill.getSkillrating());
//        }
//
//        for(Education eachEducation : resume.educations){
//            System.out.println(eachEducation.getDegree());
//            System.out.println(eachEducation.getMajor());
//            System.out.println(eachEducation.getUniversity());
//            System.out.println(eachEducation.getGradyear());
//        }
//
//
//        System.out.println("Print Resume experiences using String"+resume.getExperiences().toString());
//        System.out.println("Printing whats in resume"+resume.getExperiences()+resume.getEducations()+resume.getSkills());
//        //Adding Resume id to model
        return "createresume";


    }






}
