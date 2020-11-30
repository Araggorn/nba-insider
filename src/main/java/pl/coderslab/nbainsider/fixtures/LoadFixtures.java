package pl.coderslab.nbainsider.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoadFixtures {

    private UserFixture userFixture;
    private TeamFixture teamFixture;
    private PlayerFixture playerFixture;

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
