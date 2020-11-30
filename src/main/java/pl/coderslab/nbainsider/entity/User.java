package pl.coderslab.nbainsider.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String login;

    @NotNull
    @Size(max = 64)
    private String password;

    @NotNull
    @Column(unique=true)
    private String email;

    @ColumnDefault("false")
    private boolean admin;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Player player;

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
