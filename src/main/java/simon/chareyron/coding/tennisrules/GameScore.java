package simon.chareyron.coding.tennisrules;

public class GameScore extends Score<String> {

    protected String[] initOrderedScores() {
        return new String[]{"0","15","30","40","Av"};
    }
}
