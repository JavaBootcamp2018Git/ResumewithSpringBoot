package me.travisgray.demo.Repositories;

import me.travisgray.demo.Models.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,Long> {


    Profile findByFirstname(String name);
}
