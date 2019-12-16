package simon.chareyron.coding.tennisrules;

public class GameScore extends Score<String> {

    private static final String ADVANTAGE = "Av";

    protected String[] initOrderedScores() {
        return new String[]{"0", "15", "30", "40", ADVANTAGE};
    }

    @Override
    public boolean nextScoreForPlayer(Player winnerPointPlayer) {
        boolean winnerPointPlayerWinTheGame = false;
        Player loserPlayer = getLooserPointPlayer(winnerPointPlayer);
        if (inAdvantageForPlayer(loserPlayer)) {
            super.previousScoreForPlayer(loserPlayer);
        } else {
            winnerPointPlayerWinTheGame = super.nextScoreForPlayer(winnerPointPlayer);
        }
        return winnerPointPlayerWinTheGame;
    }

    private Player getLooserPointPlayer(Player winnerPointPlayer) {
        return Player._1 == winnerPointPlayer ? Player._2 : Player._1;
    }

    protected boolean isPlayerWon(Player winnerPointPlayer) {
        return ADVANTAGE.equals(getScorePlayer(winnerPointPlayer)) && !"40".equals(getScorePlayer(getLooserPointPlayer(winnerPointPlayer)));
    }

    private boolean inAdvantageForPlayer(Player player) {
        return getScorePlayer(player).equals(ADVANTAGE);
    }
}
