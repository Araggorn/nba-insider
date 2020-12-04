package pl.coderslab.nbainsider.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.nbainsider.app.SecurityUtils;
import pl.coderslab.nbainsider.dto.UserDto;
import pl.coderslab.nbainsider.dto.UserItemDto;
import pl.coderslab.nbainsider.entity.Team;
import pl.coderslab.nbainsider.entity.User;
import pl.coderslab.nbainsider.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllByActiveTrue() {
        return userRepository.findAllByActiveTrue();
    }


    @Override
    public void add(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
    }


    @Override
    public void delete(Long id) {
       User user = userRepository.getOne(id);
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public void update(UserDto userDto)
    {
        User user = userRepository.getOne(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
         userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public List<UserItemDto> find2all() {
       return  userRepository.findAllByActiveTrue().stream()
               .map(u -> new UserItemDto(
                       u.getId(),
                       u.getLogin(),
                       u.getEmail(),
                       u.getTeam() != null ? u.getTeam().getName(): null,
                       u.getPlayer() != null ? u.getPlayer().getFirstName() + "  " + u.getPlayer().getLastName() : null))
               .collect(Collectors.toList());

    }



}
