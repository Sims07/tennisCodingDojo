package simon.chareyron.coding.tennisrules.usecases;

import simon.chareyron.coding.tennisrules.domain.Player;
import simon.chareyron.coding.tennisrules.domain.TennisRules;

public class PlayAPointUseCase {

    private TennisRules tennisRules;

    public PlayAPointUseCase(InputTennisScorePort inputScorePort) {
        this.tennisRules = new TennisRules(inputScorePort.getTennisScore());
    }

    public void winPoint(Player winnerPointPlayer) {
        tennisRules.winPoint(winnerPointPlayer);
    }

}
