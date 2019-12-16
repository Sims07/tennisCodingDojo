package simon.chareyron.coding.tennisrules;

public class BDDTennisAssertions {

    public static BDDTennisAssertion givenTennisRuleAndInitScore(TennisRules tennisRules,String setScore, String gameScore) {
        initSetScore(tennisRules, setScore);
        initGameScore(tennisRules, gameScore);
        return new BDDTennisAssertion(tennisRules, setScore, gameScore);
    }

    private static void initGameScore(TennisRules tennisRules, String gameScore) {
        String[] gameScorePlayers = gameScore.split("-");
        tennisRules.setGameScorePlayer1(gameScorePlayers[0]);
        tennisRules.setGameScorePlayer2(gameScorePlayers[1]);
    }

    private static void initSetScore(TennisRules tennisRules, String setScore) {
        String[] setScorePlayers = setScore.split("-");
        tennisRules.setSetScorePlayer1(Integer.valueOf(setScorePlayers[0]));
        tennisRules.setSetScorePlayer2(Integer.valueOf(setScorePlayers[1]));
    }

}
