package simon.chareyron.coding.tennisrules;

public class TennisRules {

    private TennisScore tennisScore;

    public TennisRules(TennisScore tennisScore) {
        this.tennisScore = tennisScore;
    }

    public void winPoint(Player winnerPointPlayer) {
        boolean winTheGame = tennisScore.nextGameScoreForPlayer(winnerPointPlayer);
        if (winTheGame) {
            boolean winTheSet = tennisScore.nextSetScoreForPlayer(winnerPointPlayer);
            if(winTheSet){
                tennisScore.addNewSet();
            }
            tennisScore.resetGameScore();
        }
    }

    public TennisScore getTennisScore() {
        return tennisScore;
    }
}
