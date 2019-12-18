package simon.chareyron.coding.tennisrules.domain;

public class SetScore extends Score<Integer> {

    private TieBreakScore tieBreakScore;

    protected Integer[] initOrderedScores() {
        return new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    protected boolean isPlayerWon(Player winnerPointPlayer) {

        return getScorePlayer(winnerPointPlayer) >= 6 && getScoreLooserPlayer(winnerPointPlayer) < 6;
    }

    public TieBreakScore getTieBreakScore() {
        return this.tieBreakScore;
    }

    public void setTieBreakScore(TieBreakScore tieBreakScore) {
        this.tieBreakScore = tieBreakScore;
    }
}
