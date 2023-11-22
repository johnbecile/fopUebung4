package h04.strategy;

import fopbot.Field;
import fopbot.Robot;

/**
 * Interface Move strategy.
 */
public interface MoveStrategy {

    /**
     * Start method, letting the given robot move on the given field.
     *
     * @param robot the given robot
     * @param field the given field
     */
    void start(Robot robot, Field field);
}
