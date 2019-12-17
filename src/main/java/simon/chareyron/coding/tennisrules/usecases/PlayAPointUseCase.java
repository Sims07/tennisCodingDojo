package simon.chareyron.coding.tennisrules.usecases;

import simon.chareyron.coding.tennisrules.domain.Player;
import simon.chareyron.coding.tennisrules.domain.TennisScore;

public class PlayAPointUseCase {

    private TennisScore tennisScore;

    public PlayAPointUseCase(TennisScore tennisScore) {
        this.tennisScore = tennisScore;
    }

    public void winPoint(Player winnerPointPlayer) {
        boolean winTheGame = tennisScore.nextGameScoreForPlayer(winnerPointPlayer);
        if (winTheGame) {
            updateGameAndSetScore(winnerPointPlayer);
        }
    }

    private void updateGameAndSetScore(Player winnerPointPlayer) {
        boolean winTheSet = tennisScore.nextSetScoreForPlayer(winnerPointPlayer);
        if(winTheSet){
            tennisScore.addNewSet();
        }
        tennisScore.resetGameScore();
    }

    public TennisScore getTennisScore() {
        return tennisScore;
    }
}
