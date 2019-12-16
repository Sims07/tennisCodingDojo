package simon.chareyron.coding.tennisrules;

public class BDDTennisAssertions {

    public static BDDTennisAssertion givenTennisRuleAndInitScore(TennisRules tennisRules,String setScore, String gameScore) {
        tennisRules.setSetScorePlayer1(0);
        tennisRules.setSetScorePlayer2(0);
        tennisRules.setGameScorePlayer1(0);
        tennisRules.setGameScorePlayer2(0);
        return new BDDTennisAssertion(tennisRules, setScore, gameScore);
    }

}
