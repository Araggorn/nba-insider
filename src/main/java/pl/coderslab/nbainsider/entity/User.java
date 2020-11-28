package pl.coderslab.nbainsider.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
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

    private String favouriteTeam;

}
