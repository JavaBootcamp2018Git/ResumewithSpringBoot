package me.travisgray.demo.Repositories;

import me.travisgray.demo.Models.Job;
import me.travisgray.demo.Models.Skills;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long>{

    Iterable<Job> findAllBySkillsIsIn(Iterable<Skills> skills);
}
