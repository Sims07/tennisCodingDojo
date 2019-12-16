package simon.chareyron.coding.tennisrules;

import org.junit.Test;

public class TennisRulesTest {

    @Test
    public void winAPoint() {
        BDDTennisAssertions
                .givenTennisRuleAndInitScore(new TennisRules(), "0-0", "0-0")
                .whenPlayerWinPoint("1")
                .thenSetScoreIs("0-0")
                .thenGameScoreIs("15-0");
    }


}
