package tamdai.security.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tamdai.security.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
