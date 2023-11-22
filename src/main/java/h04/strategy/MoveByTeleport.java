package h04.strategy;

import fopbot.Field;
import fopbot.Robot;

/**
 * Robot type, which move by teleport.
 */
public class MoveByTeleport implements MoveStrategy {


    /**
     * Start method, letting the given robot move on the given field by teleport.
     *
     * @param robot the given robot
     * @param field the given field
     */
    @Override
    public void start(Robot robot, Field field) {
        robot.setField(field.getX(), field.getY());
    }
}
