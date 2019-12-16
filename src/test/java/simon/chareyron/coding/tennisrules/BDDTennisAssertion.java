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
        tennisRules.winPoint(winnerPointPlayer);
        return this;
    }


    public BDDTennisAssertion thenSetScoreIs(String setScore) {
        String[] setScorePlayers = setScore.split(",");
        then(tennisRules.getSetScore().getSetScorePlayer1()).isEqualTo(setScorePlayers[0]);
        then(tennisRules.getSetScore().getSetScorePlayer2()).isEqualTo(setScorePlayers[1]);
        return this;
    }

    public BDDTennisAssertion thenGameScoreIs(String gameScore) {
        String[] gameScorePlayers = setScore.split(",");
        then(tennisRules.getGameScore().getSetScorePlayer1()).isEqualTo(gameScorePlayers[0]);
        then(tennisRules.getGameScore().getSetScorePlayer2()).isEqualTo(gameScorePlayers[1]);
        return this;
    }
}
