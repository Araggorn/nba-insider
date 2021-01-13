package pl.coderslab.nbainsider.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
@EqualsAndHashCode(of = "login")
@ToString(exclude = "password")

public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(unique = true)
    private String login;

    @NotNull
    private String password;

    @NotNull
    @Column(unique=true)
    @Email
    private String email;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Player player;

    private boolean active = true;
    @Column (name="role")
    private String role = "ROLE_USER";

//    @Transient
//    @ElementCollection
//    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "username", referencedColumnName = "id"))
//    @Column(name = "role")
//    private Set<String> roles;

    public User(Long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(Long id, @NotNull @Size(min = 3, max = 50) String login, @NotNull @Size(max = 64) String password, @NotNull String email, Team team, Player player) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.team = team;
        this.player = player;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
