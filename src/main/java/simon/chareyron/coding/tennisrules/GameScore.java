package simon.chareyron.coding.tennisrules;

public class GameScore extends Score<String> {

    private static final String ADVANTAGE = "Av";

    protected String[] initOrderedScores() {
        return new String[]{"0", "15", "30", "40", ADVANTAGE};
    }

    @Override
    public void nextScoreForPlayer(Player winnerPointPlayer) {
        Player loserPlayer = Player._1 == winnerPointPlayer ? Player._2 : Player._1;
        if (inAdvantageForPlayer(loserPlayer)) {
            super.previousScoreForPlayer(loserPlayer);
        } else {
            super.nextScoreForPlayer(winnerPointPlayer);
        }
    }

    private boolean inAdvantageForPlayer(Player player) {
        return getScorePlayer(player).equals(ADVANTAGE);
    }
}
