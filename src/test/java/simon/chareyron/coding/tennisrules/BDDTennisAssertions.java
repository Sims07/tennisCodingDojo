package simon.chareyron.coding.tennisrules;

import simon.chareyron.coding.tennisrules.domain.Player;
import simon.chareyron.coding.tennisrules.domain.TennisScore;

public class BDDTennisAssertions {

    private BDDTennisAssertions() {
        //
    }

    public static BDDTennisAssertion givenTennisRuleAndInitScore(String setScore, String gameScore) {
        return givenTennisRuleAndInitScore(setScore, gameScore, null);
    }

    public static BDDTennisAssertion givenTennisRuleAndInitScore(String setScore, String gameScore, String tieBreakScore) {
        TennisScore tennisScore = new TennisScore();
        initSetScore(tennisScore, setScore);
        initGameScore(tennisScore, gameScore);
        initTieBreakScore(tennisScore, tieBreakScore);
        return new BDDTennisAssertion(tennisScore);
    }

    private static void initTieBreakScore(TennisScore tennisScore, String tieBreakScore) {
        if (tieBreakScore != null) {
            String[] tiebreakScorePlayers = tieBreakScore.split("-");
            tennisScore.setTieBreakScorePlayer(Player._1, Integer.parseInt(tiebreakScorePlayers[0]));
            tennisScore.setTieBreakScorePlayer(Player._2, Integer.parseInt(tiebreakScorePlayers[1]));
        }
    }

    private static void initGameScore(TennisScore tennisScore, String gameScore) {
        String[] gameScorePlayers = gameScore.split("-");
        tennisScore.setGameScorePlayer(Player._1, gameScorePlayers[0]);
        tennisScore.setGameScorePlayer(Player._2, gameScorePlayers[1]);
    }

    private static void initSetScore(TennisScore tennisScore, String setScore) {
        String[] setScorePlayers = setScore.split("-");
        tennisScore.setSetScorePlayer(Player._1, Integer.parseInt(setScorePlayers[0]), 1);
        tennisScore.setSetScorePlayer(Player._2, Integer.parseInt(setScorePlayers[1]), 1);
    }

}
