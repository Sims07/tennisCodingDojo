package simon.chareyron.coding.tennisrules;

public class SetScore extends Score<Integer>{

    protected Integer[] initOrderedScores() {
        return new Integer[] { 0,1,2,3,4,5,6,7 };
    }
}
