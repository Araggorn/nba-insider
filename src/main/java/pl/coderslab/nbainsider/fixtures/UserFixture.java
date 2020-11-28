package pl.coderslab.nbainsider.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.service.UserService;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

@Component
public class UserFixture {
    private UserService userService;

    private List<User> userList = Arrays.asList(
            new User(null, "Araggorn", "masło", "zerelik@o2.pl"),
            new User(null,"Araggornik", "basło", "zerelik@p2.pl"),
            new User(null, "qba", "qbeczek", "kuboniszom@gmail.com"),
            new User(null, "pinka", "malinka", "korniszonek@nba.com")
    );

    @Autowired
    public UserFixture(UserService userService) {
        this.userService = userService;
    }

    public void loadIntoDB() {
        for (User user : userList) {
            userService.add(user);
        }
    }
}
