package pl.coderslab.nbainsider.service;


import pl.coderslab.nbainsider.dto.UserDto;
import pl.coderslab.nbainsider.dto.UserItemDto;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;


import java.awt.print.Book;
import java.util.List;

public interface UserService {

    void save (User user);

    List<User> findAllUsers();

    void add(UserDto userDto);

    void delete(Long id);

    void update(UserDto userDto);

    User findById(Long id);

    List<User> findAllByActiveTrue();

    List<UserItemDto> find2all();

    void updateTeam(Long favTeamId);

    Long countUsers();

    void updatePlayer(Long favPlayerId);

    User getByLogin(String login);
}
