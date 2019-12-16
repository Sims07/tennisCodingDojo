package simon.chareyron.coding.tennisrules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Score<T> {

    private T[] orderedScores = initOrderedScores();

    protected abstract T[] initOrderedScores();

    private Map<Player, T> score = new HashMap();


    public boolean nextScoreForPlayer(Player winnerPointPlayer) {
        boolean winnerPointPlayerWon = false;
        T currentScore = getScorePlayer(winnerPointPlayer);
        int nextScoreIndex = Arrays.asList(orderedScores).indexOf(currentScore);
        if (orderedScores.length > nextScoreIndex + 1) {
            setScorePlayer(winnerPointPlayer, orderedScores[nextScoreIndex + 1]);
            winnerPointPlayerWon = isPlayerWon(winnerPointPlayer);
        } else {
            winnerPointPlayerWon = true;
        }
        return winnerPointPlayerWon;
    }


    public void previousScoreForPlayer(Player player) {
        T currentScore = getScorePlayer(player);
        int nextScoreIndex = Arrays.asList(orderedScores).indexOf(currentScore);
        setScorePlayer(player, orderedScores[nextScoreIndex - 1]);
    }

    public void reset() {
        setScorePlayer(Player._1, orderedScores[0]);
        setScorePlayer(Player._2, orderedScores[0]);
    }

    protected abstract boolean isPlayerWon(Player winnerPointPlayer);

    public T getScorePlayer1() {
        return score.get(Player._1);
    }

    public void setScorePlayer(Player player, T scorePlayer) {
        score.put(player, scorePlayer);
    }

    public T getScorePlayer(Player player) {
        return score.get(player);
    }

    public T getScorePlayer2() {
        return score.get(Player._2);
    }


}
