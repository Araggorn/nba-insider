package pl.coderslab.nbainsider.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String twitterAddress;

    @OneToMany (mappedBy = "team")
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
