package h04.robot;

import fopbot.Field;
import fopbot.Robot;
import h04.selection.FieldSelectionListener;
import h04.strategy.MoveStrategy;
import h04.strategy.MoveStrategyWithCounter;

/**
 * A variant of a robot that, when requested by a field selector, moves it to the selected field.
 */
public class MoveableRobot extends Robot implements FieldSelectionListener {

    private final MoveStrategy strategy;

    /**
     * Instantiates a new moveable robot at position (0,0) with given strategy.
     *
     * @param strategy the strategy
     */
    public MoveableRobot(MoveStrategy strategy) {
        super(0, 0);
        this.strategy = strategy;
    }

    /**
     * With the strategy of the robot mover, move the robot to the given field.
     * If the robot has a move counter, then turn left the amount of times specified
     * by the counter.
     *
     * @param field the field
     */
    @Override
    public void onFieldSelection(Field field) {
        strategy.start(this, field);
        if (this instanceof MoveStrategyWithCounter) {
            for (int i = 0; i < ((MoveStrategyWithCounter) this).getMoveCount(); i++) {
                this.turnLeft();
            }
        }
    }
}
