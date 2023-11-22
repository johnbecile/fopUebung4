package h04.robot;

import fopbot.Field;
import fopbot.Robot;
import h04.selection.FieldSelectionListener;
import h04.strategy.MoveStrategy;

import java.util.ArrayList;

/**
 * Robot mover, a robot moves to the given field with a given strategy.
 */
public class RobotMover implements FieldSelectionListener {

    private final MoveStrategy strategy;
    private final ArrayList<Robot> robots = new ArrayList<>();

    /**
     * Instantiates a new robot mover with given strategy.
     *
     * @param strategy the given strategy
     */
    public RobotMover(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Add a robot to the robot mover.
     *
     * @param robot the robot
     */
    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    /**
     * With the strategy of the robot mover, move the robots to the given field.
     *
     * @param field the field
     */
    @Override
    public void onFieldSelection(Field field) {
        for (Robot robot : robots) {
            strategy.start(robot, field);
        }
    }
}
