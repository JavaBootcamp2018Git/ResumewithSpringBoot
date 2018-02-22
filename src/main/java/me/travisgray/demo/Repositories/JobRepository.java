package me.travisgray.demo.Repositories;

import me.travisgray.demo.Models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long>{
}
