package me.travisgray.demo.Repositories;

import me.travisgray.demo.Models.Role;
import me.travisgray.demo.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(String role);

    Set<Role> findAllByUsersIs(User user);
}
