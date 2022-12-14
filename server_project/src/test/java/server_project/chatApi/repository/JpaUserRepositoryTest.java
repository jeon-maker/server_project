package server_project.chatApi.repository;

import server_project.chatApi.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class JpaUserRepositoryTest {

    @Autowired
    JpaUserRepository jpaUserRepository;

    @Test
    public void testUsers(){
        Users user = new Users();
        user.setUserName("UserA");
        Users savedUser = jpaUserRepository.save(user);

        Optional<Users> finduser = jpaUserRepository.findById(savedUser.getId());
        Users findbyusername = jpaUserRepository.findByUserName("UserB");

        System.out.println("finduser = " + finduser);
        System.out.println("savedUser = " + savedUser);

        System.out.println("findbyusername = " + findbyusername);


    }

}