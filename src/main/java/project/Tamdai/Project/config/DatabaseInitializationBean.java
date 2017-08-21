package project.Tamdai.Project.config;

import project.Tamdai.Project.entity.Role;
import project.Tamdai.Project.entity.User;
import project.Tamdai.Project.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by film on 8/17/2017.
 */

@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {

    @Autowired
    UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        // add user
        Role adminRole = new Role("admin");
        Role memberRole = new Role("member");

        User admin = new User();
        admin.setId(1l);
        admin.setFirstName("admin");
        admin.setLastName("manager");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1234");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        User member1 = new User();
        member1.setId(2l);
        member1.setFirstName("member1");
        member1.setLastName("Customer1");
        member1.setEmail("member1@gmail.com");
        member1.setPassword("1111");
        Set<Role> roles1 = new HashSet<>();
        roles1.add(memberRole);
        member1.setRoles(roles1);

        User member2 = new User();
        member2.setId(3l);
        member2.setFirstName("member2");
        member2.setLastName("Customer2");
        member2.setEmail("member2@gmail.com");
        member2.setPassword("2222");
        Set<Role> roles2 = new HashSet<>();
        roles2.add(memberRole);
        member2.setRoles(roles2);

        User member3 = new User();
        member3.setId(4l);
        member3.setFirstName("member3");
        member3.setLastName("Customer3");
        member3.setEmail("member3@gmail.com");
        member3.setPassword("2222");
        Set<Role> roles3 = new HashSet<>();
        roles3.add(memberRole);
        member3.setRoles(roles3);

        userRepository.save(admin);
        userRepository.save(member1);
        userRepository.save(member2);
        userRepository.save(member3);
    }
}
