package me.travisgray.demo.Repositories;

import me.travisgray.demo.Models.Education;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education,Long> {
}
