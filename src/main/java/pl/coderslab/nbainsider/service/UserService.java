package pl.coderslab.nbainsider.service;


import pl.coderslab.nbainsider.entity.User;


import java.awt.print.Book;
import java.util.List;

public interface UserService {

    void save (User user);

    List<User> findAllUsers();

    void add(User user);


    void delete(Long id);

    void update(User user);

    User findById(Long id);

}
