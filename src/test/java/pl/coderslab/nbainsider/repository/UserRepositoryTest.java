package pl.coderslab.nbainsider.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;
import pl.coderslab.nbainsider.entity.User;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
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
        userRepository.save(user1);
        //when
        try {
            userRepository.save(user2);
            Assertions.fail("Exception should have been thrown");
        } catch (Exception e) {
            Assertions.assertEquals(DataIntegrityViolationException.class, e.getClass());
        }

    }

    @Test
    public void shouldNotAllowToSaveTwoUsersWithTheSameEmailLambda() {
        //given
        User user1 = testUser();
        User user2 = testUser();
        userRepository.save(user1);
        //when then
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> userRepository.save(user2));
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