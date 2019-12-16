package simon.chareyron.coding.tennisrules;

import static org.assertj.core.api.BDDAssertions.then;

public class BDDTennisAssertion {

    private final TennisRules tennisRules;
    private final String setScore;
    private final String gameScore;

    public BDDTennisAssertion(TennisRules tennisRules, String setScore, String gameScore) {
        this.tennisRules = tennisRules;
        this.setScore = setScore;
        this.gameScore = gameScore;
    }

    public BDDTennisAssertion whenPlayerWinPoint(String winnerPointPlayer) {
        Player player="1".equals(winnerPointPlayer)?Player._1:Player._2;
        tennisRules.winPoint(player);
        return this;
    }


    public BDDTennisAssertion thenSetScoreIs(String expectedSetScore) {
        String[] setScorePlayers = expectedSetScore.split("-");
        then(tennisRules.getSetScore().getScorePlayer1().toString()).isEqualTo(setScorePlayers[0]);
        then(tennisRules.getSetScore().getScorePlayer2().toString()).isEqualTo(setScorePlayers[1]);
        return this;
    }

    public BDDTennisAssertion thenGameScoreIs(String expectedGameScore) {
        String[] gameScorePlayers = expectedGameScore.split("-");
        then(tennisRules.getGameScore().getScorePlayer1()).isEqualTo(gameScorePlayers[0]);
        then(tennisRules.getGameScore().getScorePlayer2()).isEqualTo(gameScorePlayers[1]);
        return this;
    }
}
