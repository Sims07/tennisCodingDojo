package simon.chareyron.coding.tennisrules;

import org.junit.Test;

import static simon.chareyron.coding.tennisrules.BDDTennisAssertions.*;

public class TennisRulesTest {

    @Test
    public void winAPointFrom0() {
        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("15-0");

        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-0")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("0-15");
    }

    @Test
    public void winAPointFrom15() {
        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "15-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("30-0");

        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-15")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("0-30");
    }

    @Test
    public void winAPointFrom30() {
        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "30-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("40-0");

        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-30")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("0-40");
    }

    @Test
    public void winAPointFrom4040() {
        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-40")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("Av-40");

        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-40")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("40-Av");
    }

    @Test
    public void winAPointFrom40Av_Equality() {
        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-Av")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("40-40");

        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "Av-40")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("40-40");
    }

    @Test
    public void winAPointAndAGame() {
        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("1-0")
                .thenGameScoreIs("0-0");

        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-40")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-1")
                .thenGameScoreIs("0-0");
    }

    @Test
    public void winAPointAndAGameInAdvantage() {
        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "Av-40")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("1-0")
                .thenGameScoreIs("0-0");

        givenTennisRuleAndInitScore(new TennisRules(), "0-0", "40-Av")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("0-1")
                .thenGameScoreIs("0-0");
    }

    @Test
    public void winASetFromSet5ToSet6() {
        givenTennisRuleAndInitScore(new TennisRules(), "5-4", "40-30")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("6-4","0-0")
                .thenGameScoreIs("0-0");

        givenTennisRuleAndInitScore(new TennisRules(), "2-5", "30-40")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("2-6","0-0")
                .thenGameScoreIs("0-0");
    }

    @Test
    public void winASetFromSet6ToSet7() {
        givenTennisRuleAndInitScore(new TennisRules(), "6-5", "40-30")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("7-5","0-0")
                .thenGameScoreIs("0-0");

        givenTennisRuleAndInitScore(new TennisRules(), "5-6", "30-40")
                .whenPlayerWinPoint("2")
                .thenSetScoreIs("5-7","0-0")
                .thenGameScoreIs("0-0");
    }

}
