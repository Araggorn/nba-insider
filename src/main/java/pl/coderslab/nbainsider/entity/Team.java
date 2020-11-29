package pl.coderslab.nbainsider.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Team {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String twitterAddress;

    public Team(Long id, @NotNull String name, @NotNull String twitterAddress) {
        this.id = id;
        this.name = name;
        this.twitterAddress = twitterAddress;
    }
}
