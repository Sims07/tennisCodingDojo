package simon.chareyron.coding.tennisrules.usecases;

import simon.chareyron.coding.tennisrules.domain.Player;
import simon.chareyron.coding.tennisrules.domain.Score;
import simon.chareyron.coding.tennisrules.domain.TennisScore;

public class PlayAPointUseCase {

    private TennisScore tennisScore;

    public PlayAPointUseCase(TennisScore tennisScore) {
        this.tennisScore = tennisScore;
    }

    public void winPoint(Player winnerPointPlayer) {
        Score<?> scoreToUpdate = selectGameOrTieBreakScoreToUpdate();
        boolean winTheGame = scoreToUpdate.nextScoreForPlayer(winnerPointPlayer);
        if (winTheGame) {
            applyWinningGameRule(winnerPointPlayer);
        }
    }

    private Score<?> selectGameOrTieBreakScoreToUpdate() {
        return tennisScore.isInTieBreak() ? tennisScore.getTieBreakScore() : tennisScore.getGameScore();
    }

    private void applyWinningGameRule(Player winnerPointPlayer) {
        boolean winTheSet = tennisScore.nextSetScoreForPlayer(winnerPointPlayer);
        if (winTheSet) {
            tennisScore.addNewSet();
        } else {
            if (tennisScore.isInTieBreak()) {
                tennisScore.beginTieBreak();
            }
        }
        tennisScore.resetGameScore();
    }

    public TennisScore getTennisScore() {
        return tennisScore;
    }
}
