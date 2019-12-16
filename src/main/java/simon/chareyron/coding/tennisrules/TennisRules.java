package simon.chareyron.coding.tennisrules;

public class TennisRules {

    private SetScore setScore;
    private GameScore gameScore;

    public TennisRules() {
        this.gameScore=new GameScore();
        this.setScore=new SetScore();
    }

    public void winPoint(Player winnerPointPlayer) {
        gameScore.nextScoreForPlayer(winnerPointPlayer);
    }

    public void setSetScorePlayer1(int setScorePlayer1) {
        this.setScore.setScorePlayer(Player._1,setScorePlayer1);
    }

    public void setGameScorePlayer1(String gameScorePlayer1) {
        this.gameScore.setScorePlayer(Player._1,gameScorePlayer1);
    }

    public void setSetScorePlayer2(int setScorePlayer2) {
        this.setScore.setScorePlayer(Player._2,setScorePlayer2);
    }

    public void setGameScorePlayer2(String scorePlayer2) {
        this.gameScore.setScorePlayer(Player._2,scorePlayer2);
    }

    public SetScore getSetScore() {
        return this.setScore;
    }

    public GameScore getGameScore() {
        return this.gameScore;
    }
}
