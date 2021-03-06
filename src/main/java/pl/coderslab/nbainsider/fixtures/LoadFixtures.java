package pl.coderslab.nbainsider.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class LoadFixtures {

    private final UserFixture userFixture;
    private final TeamFixture teamFixture;
    private final PlayerFixture playerFixture;

    @Autowired
    public LoadFixtures(UserFixture userFixture, TeamFixture teamFixture, PlayerFixture playerFixture) {
        this.userFixture = userFixture;
        this.teamFixture = teamFixture;
        this.playerFixture = playerFixture;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {

        teamFixture.loadIntoDB();
        playerFixture.loadIntoDB();
        userFixture.loadIntoDB();

    }
}
