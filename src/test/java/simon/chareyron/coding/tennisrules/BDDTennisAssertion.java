package simon.chareyron.coding.tennisrules;

import simon.chareyron.coding.tennisrules.domain.Player;
import simon.chareyron.coding.tennisrules.usecases.InputTennisScorePort;
import simon.chareyron.coding.tennisrules.usecases.PlayAPointUseCase;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.BDDAssertions.then;

public class BDDTennisAssertion {

    private final PlayAPointUseCase playAPointUseCase;
    private final String setScore;
    private final String gameScore;
    private final InputTennisScorePort inputScorePort;

    public BDDTennisAssertion(InputTennisScorePort inputScorePort, String setScore, String gameScore) {
        this.playAPointUseCase = new PlayAPointUseCase(inputScorePort);
        this.inputScorePort = inputScorePort;
        this.setScore = setScore;
        this.gameScore = gameScore;
    }

    public BDDTennisAssertion whenPlayerWinPoint(String winnerPointPlayer) {
        Player player = "1".equals(winnerPointPlayer) ? Player._1 : Player._2;
        playAPointUseCase.winPoint(player);
        return this;
    }


    public BDDTennisAssertion thenSetScoreIs(String... expectedSetScores) {
        AtomicInteger setIndex = new AtomicInteger(1);
        Arrays.asList(expectedSetScores).forEach(expectedSetScore -> {
            String[] setScorePlayers = expectedSetScore.split("-");
            then(inputScorePort.getTennisScore().getSetScore(setIndex.get()).getScorePlayer1().toString()).isEqualTo(setScorePlayers[0]);
            then(inputScorePort.getTennisScore().getSetScore(setIndex.get()).getScorePlayer2().toString()).isEqualTo(setScorePlayers[1]);
            setIndex.getAndIncrement();
        });
        return this;
    }

    public BDDTennisAssertion thenGameScoreIs(String expectedGameScore) {
        String[] gameScorePlayers = expectedGameScore.split("-");
        then(inputScorePort.getTennisScore().getGameScore().getScorePlayer1()).isEqualTo(gameScorePlayers[0]);
        then(inputScorePort.getTennisScore().getGameScore().getScorePlayer2()).isEqualTo(gameScorePlayers[1]);
        return this;
    }

    public BDDTennisAssertion thenTieBreakScoreIs(String expectedTieBreakScore) {
        String[] gameScorePlayers = expectedTieBreakScore.split("-");
        then(inputScorePort.getTennisScore().getTieBreakScore().getScorePlayer1().toString()).isEqualTo(gameScorePlayers[0]);
        then(inputScorePort.getTennisScore().getTieBreakScore().getScorePlayer2().toString()).isEqualTo(gameScorePlayers[1]);
        return this;
    }
}
