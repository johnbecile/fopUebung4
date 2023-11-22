package h04.strategy;

/**
 * Interface Move strategy with counter.
 */
public interface MoveStrategyWithCounter extends MoveStrategy {

    /**
     * Returns the amount of move performed the last time the start method was called.
     *
     * @return the move count
     */
    int getMoveCount();
}
