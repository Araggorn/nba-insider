package pl.coderslab.nbainsider.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Size(max = 50)
    private String twitterAddress;

    @OneToMany(mappedBy = "team")
    List<User> users = new ArrayList<>();

    public Team(Long id, @NotNull String name, @NotNull String twitterAddress) {
        this.id = id;
        this.name = name;
        this.twitterAddress = twitterAddress;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", twitterAddress='" + twitterAddress + '\'' +
                '}';
    }
}
