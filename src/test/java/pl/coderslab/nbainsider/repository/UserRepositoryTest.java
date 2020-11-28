package pl.coderslab.nbainsider.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import pl.coderslab.nbainsider.entity.User;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void shouldFindUserByEmail() {
        //given
        User user = new User();
        user.setPassword("masło");
        String email = "Zgaslo@maslo";
        user.setEmail(email);
        user.setLogin("Araggorn");
        User a = testEntityManager.persist(user);
        //when
        User result = userRepository.findByEmail(email);
        //then
        assertEquals(a, result);
    }

    @Test
    public void areTwoUsersEqual() {
        User user1 = testUser();
        User user2 = testUser();

        assertEquals(user1, user2);
    }

    @Test
    public void shouldNotAllowToSaveTwoUsersWithTheSameEmail() {
        //given
        User user1 = testUser();
        User user2 = testUser();
        transactionTemplate.execute(context -> userRepository.saveAndFlush(user1));
        //when
        transactionTemplate.execute(context -> userRepository.saveAndFlush(user2));


    }

    private User testUser() {
        User user1 = new User();
        user1.setPassword("masło");
        user1.setEmail("Zgaslo@maslo.pl");
        user1.setLogin("Araggorn");
        //user1.setId(1L);
        return user1;
    }
}