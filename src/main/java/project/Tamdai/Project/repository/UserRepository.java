package project.Tamdai.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Tamdai.Project.entity.User;

/**
 * Created by film on 08/17/2017.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
