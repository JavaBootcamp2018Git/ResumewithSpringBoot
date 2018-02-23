package me.travisgray.demo.Repositories;


import me.travisgray.demo.Models.Role;
import me.travisgray.demo.Models.Skills;
import me.travisgray.demo.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Long> {
 User findByUsername(String username);
 User findByEmail(String email);
 Long countByEmail(String email);
 Long countByUsername(String email);

 // get a list of Users who have any skill that exactly matches any of the skills
 Collection<User> findBySkillsIsAndRolesIs(Skills skill, Role role);

 Long countByRoles(Role role);
}
