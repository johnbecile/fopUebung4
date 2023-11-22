package h04.strategy;

import fopbot.Direction;
import fopbot.Field;
import fopbot.Robot;

public class MoveByWalk implements MoveStrategyWithCounter {
    private int moveCount = -1;

    /**
     * Start method, letting the given robot move on the given field by walk.
     *
     * @param robot the given robot
     * @param field the given field
     */
    @Override
    public void start(Robot robot, Field field) {
        moveCount = 0;
        int x = robot.getX();
        int y = robot.getY();
        int toX = field.getX();
        int toY = field.getY();
        while ((robot.getX() != field.getX()) || (robot.getY() != field.getY())) {
            // move the robot to the same x coordinate as the field
            if (x < toX) {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnLeft();
                }
                while (x < toX) {
                    robot.move();
                    x = robot.getX();
                    moveCount++;
                }
            }
            if (x > toX) {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnLeft();
                }
                while (x > toX) {
                    robot.move();
                    x = robot.getX();
                    moveCount++;
                }
            }
            // move the robot to the same y coordinate as the field
            if (y < toY) {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnLeft();
                }
                while (y < toY) {
                    robot.move();
                    y = robot.getY();
                    moveCount++;
                }
            }
            if (y > toY) {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnLeft();
                }
                while (y > toY) {
                    robot.move();
                    y = robot.getY();
                    moveCount++;
                }
            }
        }
    }

    /**
     * Returns the amount of move performed the last time the start method was called.
     *
     * @return the move count
     */
    @Override
    public int getMoveCount() {
        return moveCount;
    }
}
