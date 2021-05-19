import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class hclFootballTests {

    @Test
    public void testValidateFootBallTeamName() throws FileNotFoundException {
        String teamName = new FootballTeamStats().getTeamNameHasSmallestScoreDifference();
        Assert.assertEquals("Aston_Villa", teamName, "Validation of teamName failed.");
    }

    @Test
    public void testValidateFootBallTeamNameErrorScenario() throws FileNotFoundException {
        String teamName = new FootballTeamStats().getTeamNameHasSmallestScoreDifference();
        Assert.assertNotEquals("Blackburn", teamName, "Validation of teamName failed.");
    }
}
