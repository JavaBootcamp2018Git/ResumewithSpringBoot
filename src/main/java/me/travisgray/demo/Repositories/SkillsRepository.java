package me.travisgray.demo.Repositories;

import me.travisgray.demo.Models.Skills;
import org.springframework.data.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skills,Long> {

    long countAllByIdIs(long id);

    Skills findBySkillAndSkillrating(String skill, String skillrating);

}
