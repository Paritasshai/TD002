package project.Tamdai.Project.config;

import project.Tamdai.Project.entity.User;
import project.Tamdai.Project.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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

        User admin = new User();
        admin.setId(1l);
        admin.setUsername("admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1111");

        User member1 = new User();
        member1.setId(2l);
        member1.setUsername("member1");
        member1.setEmail("member1@gmail.com");
        member1.setPassword("2222");

        User member2 = new User();
        member2.setId(3l);
        member2.setUsername("member2");
        member2.setEmail("member2@gmail.com");
        member2.setPassword("2222");

        User member3 = new User();
        member3.setId(4l);
        member3.setUsername("member3");
        member3.setEmail("member3@gmail.com");
        member3.setPassword("2222");

        userRepository.save(admin);
        userRepository.save(member1);
        userRepository.save(member2);
        userRepository.save(member3);
    }
}
