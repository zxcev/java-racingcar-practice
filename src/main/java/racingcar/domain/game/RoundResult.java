package racingcar.domain.game;

import java.util.List;

public record RoundResult(
        List<MoveResult> moveResults
) {
    public MoveResult getAt(final int index) {
        return moveResults.get(index);
    }
}
