package simon.chareyron.coding.tennisrules;

import org.junit.Test;

public class TennisRulesTest {

    @Test
    public void winAPointFrom0() {
        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("15-0");

        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-0")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("0-15");
    }

    @Test
    public void winAPointFrom15() {
        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "15-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("30-0");

        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-15")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("0-30");
    }

    @Test
    public void winAPointFrom30() {
        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "30-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("40-0");

        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-30")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("0-40");
    }

    @Test
    public void winAPointFrom4040() {
        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-40")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("Av-40");

        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-40")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("40-Av");
    }

    @Test
    public void winAPointFrom40Av_Equality() {
        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-Av")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("40-40");

        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "Av-40")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("40-40");
    }

    @Test
    public void winAPointAndAGame() {
        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("1-0")
                .thenGameScoreIs("0-0");

        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-40")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-1")
                .thenGameScoreIs("0-0");
    }

    @Test
    public void winAPointAndAGameInAdvantage() {
        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "Av-40")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("1-0")
                .thenGameScoreIs("0-0");

        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-Av")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-1")
                .thenGameScoreIs("0-0");
    }

}
