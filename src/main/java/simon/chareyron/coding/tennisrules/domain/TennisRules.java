package simon.chareyron.coding.tennisrules.domain;

public class TennisRules {

    private TennisScore tennisScore;

    public TennisRules(TennisScore tennisScore) {
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
}
