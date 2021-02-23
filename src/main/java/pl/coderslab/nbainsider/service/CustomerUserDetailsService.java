package pl.coderslab.nbainsider.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.nbainsider.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        log.debug("Searching for user by username '{}", login);

        if (!repository.existsByLogin(login)) {
            throw new UsernameNotFoundException(String.format("Username %s not found", login));
        }

        final pl.coderslab.nbainsider.entity.User userEntity = repository.getByLogin(login);
        UserDetails user = User.withUsername(userEntity.getLogin()).password(userEntity.getPassword()).authorities(userEntity.getRole()).build();
        return user;
//        return new User(userEntity.getLogin(),
//                userEntity.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));

        //        userEntity.getRoles().stream().
        //       map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
