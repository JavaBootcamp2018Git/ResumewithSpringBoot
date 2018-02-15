package me.travisgray.demo.Repositories;

import me.travisgray.demo.Models.Resume;
import org.springframework.data.repository.CrudRepository;

public interface ResumeRepository extends CrudRepository<Resume,Long> {


    Resume findById(long id);
}
