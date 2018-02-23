package me.travisgray.demo.Controller;

import me.travisgray.demo.Models.*;
import me.travisgray.demo.Repositories.*;
import me.travisgray.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Controller
public class MainController {

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    CoverLetterRepo coverLetterRepo;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserService userService;


    @GetMapping("/findrolesdata")
    public String createuserroles(){
        Role jobseekerrole = new Role();
        jobseekerrole.setRole("JOBSEEKER");
        roleRepository.save(jobseekerrole);

        Role recruiterrole = new Role();
        recruiterrole.setRole("RECRUITER");
        roleRepository.save(recruiterrole);

        return "Redirect:/login";

    }


    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,HttpServletRequest request ){

        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "registration";
        } else{
            userService.saveUser(user);
            model.addAttribute("message","User Account Successfully Created");
        }
        return "index";
    }


    @GetMapping("/adminregister")
    public String showadminRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/adminregister")
    public String processadminregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){

        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "registration";
        }else{
            //                Only Admins can register other admin users no button access in nav bar
            userService.saveAdmin(user);
            model.addAttribute("message","Admin Account Successfully Created");
        }
        return "index";
    }










    @GetMapping("/addResume")
    public String addResume(Model model) {
        //Creating Profile model for new form
        Profile profile = new Profile();
        model.addAttribute("resume", new Profile());
        return "addresume";
    }

//    Find ID from resume the return to indexpage so that it see the id use path variable to make sure id is passed then return to index then whenn going to create reume route loop through
//    Try this on on class to start then move into other collections

//    @RequestMapping("/indexwithresume")
//    public String showIndex(@ModelAttribute("resume") Profile resume,Model model) {
//        model.addAttribute("resume", profileRepository.findAll());
//        return "index";
//
//    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/addCover")
    public String createCoverLetter(Model model){
        model.addAttribute("coverletter",new CoverLetter());
        return "addcoverletter";
    }

    @PostMapping("/addCover")
    public String saveCoverLetter(@Valid @ModelAttribute("coverletter")CoverLetter coverLetter,Model model,BindingResult result){
        {
            if(result.hasErrors()){
                return "addcoverletter";
            }

            coverLetterRepo.save(coverLetter);
            model.addAttribute("coverletterlist",coverLetterRepo.findAll());
            return "coverletter.list";

        }
    }



    @GetMapping("/detail/coverletter/{id}")
    public String showCoverLetterinfo(@PathVariable("id") long id, Model model) {

//        Test to see if route fined all coverletter including new coverletter
        model.addAttribute("coverletterlist",coverLetterRepo.findAll());

        return "coverletter.list";
    }


    @GetMapping("/update/coverletter/{id}")
    public String updateCoverLetterinfo(@PathVariable("id") long id, Model model) {
        model.addAttribute("coverletter", coverLetterRepo.findOne(id));
        return "addcoverletter";
    }

    @GetMapping("/delete/coverletter/{id}")
    public String deleteCoverLetterinfo(@PathVariable("id") long id, Model model) {
        model.addAttribute("coverletter", coverLetterRepo.findOne(id));
        coverLetterRepo.delete(id);
        return "coverletter.list";
    }



    @GetMapping("/createcoverletter")
    public String showfinalcoverletter(Model model){
        model.addAttribute("coverletterlist",coverLetterRepo.findAll());
        return "finalcoverletter";

    }










    //Process and save Profile form Binding Result nesscary for Thymeleaf Valaidation
    @PostMapping("/addResume")
    public String saveResume(@Valid @ModelAttribute("resume") Profile profile, Model model, BindingResult result) {
        {
            if (result.hasErrors()) {
                return "addresume";


            }

            profileRepository.save(profile);
            model.addAttribute("resumelist", profileRepository.findAll());
            return "resume.list";
        }
    }



    //Updating id for skillslist Testing
//    Passing id from prevously created skills

    @GetMapping("/detail/resume/{id}")
    public String showResumeprofileinfo(@PathVariable("id") long id, Model model) {

//        Test to see if route fined all resume including new resume
        model.addAttribute("resumelist", profileRepository.findAll());

        return "resume.list";
    }


    @GetMapping("/update/resume/{id}")
    public String updateResumeprofileinfo(@PathVariable("id") long id, Model model) {
        model.addAttribute("resume", profileRepository.findOne(id));
        return "addresume";
    }

    @GetMapping("/delete/resume/{id}")
    public String deleteResumeprofile(@PathVariable("id") long id, Model model) {
        model.addAttribute("resume", profileRepository.findOne(id));
        profileRepository.delete(id);
        return "resume.list";
    }

    @GetMapping("/resumeList")
    public String showresumelist(Model model){
        model.addAttribute("resumelist", profileRepository.findAll());
        return "resume.list";
    }






    @GetMapping("/addSkill")
    public String addSkill(Model model) {
        Skills skills = new Skills();
        model.addAttribute("skills", new Skills());
        return "addskill";
    }
//Must pass model attribute for thyemleaf to see object for update buttons example in html code <p class="lead text-center"><a class="btn btn-lg btn-info" th:href="@{/update/{id}(id=${skills.id})}" target="_self">
//</a></p>
    @PostMapping("/addSkill")
    public String saveSkill(@Valid @ModelAttribute("skills") Skills skill,Model model, BindingResult result) {

        {
            if (result.hasErrors()) {
                return "addskill";
            }

            skillsRepository.save(skill);
            model.addAttribute("skilllist",skillsRepository.findAll());
            return "skill.list";
        }
    }


//Updating id for skillslist Testing
//    Passing id from prevously created skills

    @GetMapping("/detail/skill/{id}")
    public String showSkills(@PathVariable("id") long id, Model model) {

//        Test to see if route fined all skills including new user skill
        model.addAttribute("skilllist", skillsRepository.findAll());

        return "skill.list";
    }


    @GetMapping("/update/skill/{id}")
    public String updateSkills(@PathVariable("id") long id, Model model) {
        model.addAttribute("skills", skillsRepository.findOne(id));
        return "addskill";
    }

    @GetMapping("/delete/skill/{id}")
    public String deleteSkills(@PathVariable("id") long id, Model model) {
        model.addAttribute("skills", skillsRepository.findOne(id));
        skillsRepository.delete(id);
        return "skill.list";
    }

//Get mapping throwing id errors thymeleaf fixed by passing in model of skills other routes working without model attribute Thymeleaf fix
    @GetMapping("/skillList")
    public String showskilllist(Model model ,@ModelAttribute("skills")Skills skills){
        Skills s = new Skills("Teacher","Advanced");
        model.addAttribute("skilllist",skillsRepository.findAll());
        skillsRepository.save(s);
        return "skill.list";
    }







    @GetMapping("/addEducation")
    public String addEducation(Model model) {
        Education education = new Education();
        model.addAttribute("education", new Education());
        return "addeducation";
    }

    @PostMapping("/addEducation")
    public String saveEducation(@Valid @ModelAttribute("education") Education education,Model model, BindingResult result) {

        {
            if (result.hasErrors()) {
                return "addeducation";


            }

            educationRepository.save(education);
            model.addAttribute("educationlist",educationRepository.findAll());
            System.out.println(educationRepository.toString());
            System.out.println(education.getGradyear()+education.getDegree()+education.getMajor()+education.getUniversity()+education.getId());
            return "education.list";
        }
    }



    @GetMapping("/update/education/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model) {
        model.addAttribute("education",educationRepository.findOne(id));
        return "addeducation";
    }

    @GetMapping("/delete/education/{id}")
    public String deleteEducation(@PathVariable("id") long id, Model model) {
        model.addAttribute("education",educationRepository.findOne(id));
        educationRepository.delete(id);
        return "education.list";
    }


    @GetMapping("/detail/education/{id}")
    public String showEducations(@PathVariable("id") long id, Model model) {

//        Test to see if route fined all educations including new user education
        model.addAttribute("educationlist",educationRepository.findAll());
        return "education.list";
    }

    @GetMapping("/eduList")
    public String showEducationlist(Model model){
        model.addAttribute("educationlist",educationRepository.findAll());
        return "education.list";
    }



    @GetMapping("/addExperience")
    public String addExperience(Model model) {
        Experience experience = new Experience();
        model.addAttribute("experience", new Experience());
        return "addexperience";
    }

    @PostMapping("/addExperience")
    public String saveExperience(@Valid @ModelAttribute("experince") Experience experience,Model model, BindingResult result) {
        {
            if (result.hasErrors()) {
                return "addexperience";
            }
        }

        experienceRepository.save(experience);
        model.addAttribute("experiencelist",experienceRepository.findAll());
        System.out.println(experienceRepository.toString());
        System.out.println(experience.getJobtitle()+experience.getCompanytitle()+experience.getJobtitle()+experience.getStartDate()+experience.getEndDate());
        return "experience.list";
    }

    @GetMapping("/update/experience/{id}")
    public String updateExperience(@PathVariable("id") long id, Model model) {
        model.addAttribute("experience",experienceRepository.findOne(id));
        return "addexperience";
    }

    @GetMapping("/delete/experience/{id}")
    public String deleteExperience(@PathVariable("id") long id, Model model) {
        model.addAttribute("experience",experienceRepository.findOne(id));
        experienceRepository.delete(id);
        return "experience.list";
    }


    @GetMapping("/detail/experience/{id}")
    public String showExperience(@PathVariable("id") long id, Model model) {
//        Test to see if route fined all educations including new user education
//        Test to see if route fined all educations including new user education
        model.addAttribute("experiencelist",experienceRepository.findAll());
        return "experience.list";
    }

    @GetMapping("/expList")
    public String showExperiencelist(Model model){
        model.addAttribute("experiencelist",experienceRepository.findAll());
        return "experience.list";
    }


//passing all models to method to for thymeleaf access
    //Passing in all models and finding id of resume then adding that model back into Thymeleaf for template access need to add {id} to end of this Post rout ex: createResume/{id}
//    Most be Post Mapping to get id

    //Get mapping displays html form properly with dataloader entries
    @GetMapping("/createResume")
    public String createResume(HttpServletRequest request,Model model){

        model.addAttribute("experiencelist",experienceRepository.findAll());
        model.addAttribute("educationlist",educationRepository.findAll());
        model.addAttribute("skilllist",skillsRepository.findAll());
        model.addAttribute("resumelist", profileRepository.findAll());

        return "createresume2";


    }

    @GetMapping("/addJob")
    public String addjobform(Model model){
        Job job = new Job();
        model.addAttribute("job",new Job());
        return "jobform";
        }

    @PostMapping("/addJob")
    public String processjobform(Model model, @Valid @ModelAttribute("job") Job job, BindingResult result){

        {
            if (result.hasErrors()) {
                return "jobform";
            }
        }

        jobRepository.save(job);
        model.addAttribute("joblist",jobRepository.findAll());
        return "joblist";
    }

    @GetMapping("/JobList")
    public String joblist(Model model){
        model.addAttribute("joblist",jobRepository.findAll());
        return "joblist";
    }

    @GetMapping("/update/job/{id}")
    public String updatejob(@PathVariable("id") long id, Model model) {
        model.addAttribute("job",jobRepository.findOne(id));
        return "jobform";
    }

    @GetMapping("/delete/job/{id}")
    public String deletejob(@PathVariable("id") long id, Model model) {
        model.addAttribute("job ",jobRepository.findOne(id));
        jobRepository.delete(id);
        return "joblist";
    }


    @GetMapping("/detail/job/{id}")
    public String showjob(@PathVariable("id") long id, Model model) {
//        Test to see if route fined all educations including new user education
//        Test to see if route fined all educations including new user education
        model.addAttribute("joblist",jobRepository.findAll());
        return "joblist";
    }


    @GetMapping("/addskillstojob/{id}")
    public String addSkilltoJob(@PathVariable("id") long jobid, Model model)
    {
//        Job thisjob = jobRepository.findOne(new Long(jobid));
//        Iterable skillsinJob = thisjob.getSkills();
        model.addAttribute("job",jobRepository.findOne(new Long(jobid)));
        model.addAttribute("skilllist",skillsRepository.findAll());
        return "skilladdjob";
    }

    @PostMapping("/addskillstojob/{jobid}")
    public String addSkillstoJobs(@ModelAttribute("skill") Skills s,@RequestParam("skills")String skillid, @PathVariable("jobid") long jobID, Model model){



                System.out.println("JOBID"+jobID);
        System.out.println();
        Job j =jobRepository.findOne(new Long(jobID));
        System.out.println(j.getTitle());


        j.addskilltojob(s);
        jobRepository.save(j);

        s = skillsRepository.findOne(new Long(skillid));


//        The TransientObjectException comes whenever you try to save the Object without saving the appropriate Joins.
//                You have to save the UserInfoEntity first and afterwards you can save your PlayerInfoEntity class.
//
//        player.setUserId(new UserInfoEntity());
//
//        By using this you are assigning particular UserInfoEntity to PlayerInfoEntity.
//                But UserInfoEntity does not have any ID. How would both get mapped ? That is why the exception is coming.


        System.out.println(s.getSkill());
        model.addAttribute("joblist",jobRepository.findAll());
        model.addAttribute("skilllist",skillsRepository.findAll());
        return "joblistwithskills";

    }


    }




