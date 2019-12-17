package simon.chareyron.coding.tennisrules;

import simon.chareyron.coding.tennisrules.domain.TennisScore;
import simon.chareyron.coding.tennisrules.usecases.PlayAPointUseCase;

public class BDDTennisAssertions {

    public static BDDTennisAssertion givenTennisRuleAndInitScore(String setScore, String gameScore) {
        TennisScore tennisScore = new TennisScore();
        initSetScore(tennisScore, setScore);
        initGameScore(tennisScore, gameScore);
        return new BDDTennisAssertion(new PlayAPointUseCase(tennisScore), setScore, gameScore);
    }

    private static void initGameScore(TennisScore tennisScore, String gameScore) {
        String[] gameScorePlayers = gameScore.split("-");
        tennisScore.setGameScorePlayer1(gameScorePlayers[0]);
        tennisScore.setGameScorePlayer2(gameScorePlayers[1]);
    }

    private static void initSetScore(TennisScore tennisScore, String setScore) {
        String[] setScorePlayers = setScore.split("-");
        tennisScore.setSetScorePlayer1(Integer.valueOf(setScorePlayers[0]), 1);
        tennisScore.setSetScorePlayer2(Integer.valueOf(setScorePlayers[1]), 1);
    }

}
