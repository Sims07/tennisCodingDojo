package simon.chareyron.coding.tennisrules.domain;

import java.util.HashMap;
import java.util.Map;

public class TennisScore {
    private int currentSet;
    private Map<Integer, SetScore> setScores;
    private GameScore gameScore;

    public TennisScore() {
        this.currentSet = 1;
        this.gameScore = new GameScore();
        this.setScores = new HashMap<>();
    }

    public void addNewSet() {
        this.currentSet++;
        SetScore newSetScore = new SetScore();
        newSetScore.reset();
        setScores.put(currentSet, newSetScore);
    }

    public void setSetScorePlayer1(int setScorePlayer1, int setNumber) {
        SetScore setScoreToUpdate = getOrCreateSetScore(setNumber);
        setScoreToUpdate.setScorePlayer(Player._1, setScorePlayer1);
    }


    public void setSetScorePlayer2(int setScorePlayer2, int setNumber) {
        SetScore setScoreToUpdate = getOrCreateSetScore(setNumber);
        setScoreToUpdate.setScorePlayer(Player._2, setScorePlayer2);
    }

    public void setGameScorePlayer1(String gameScorePlayer1) {
        this.gameScore.setScorePlayer(Player._1, gameScorePlayer1);
    }

    public SetScore getSetScore(int setNumber) {
        return setScores.get(setNumber);
    }

    private SetScore getOrCreateSetScore(int setNumber) {
        SetScore setScoreToUpdate = setScores.get(setNumber);
        if (setScoreToUpdate == null) {
            setScoreToUpdate = new SetScore();
            setScores.put(setNumber, setScoreToUpdate);
        }
        return setScoreToUpdate;
    }


    public void setGameScorePlayer2(String scorePlayer2) {
        this.gameScore.setScorePlayer(Player._2, scorePlayer2);
    }

    public GameScore getGameScore() {
        return this.gameScore;
    }


    public boolean nextGameScoreForPlayer(Player winnerPointPlayer) {
        return gameScore.nextScoreForPlayer(winnerPointPlayer);
    }

    public boolean nextSetScoreForPlayer(Player winnerPointPlayer) {
        return getCurrentSetScore().nextScoreForPlayer(winnerPointPlayer);
    }

    public void resetGameScore() {
        gameScore.reset();
    }

    private SetScore getCurrentSetScore() {
        return setScores.get(currentSet);
    }
}
