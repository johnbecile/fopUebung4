package h04;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;
import h04.robot.MoveableRobot;
import h04.robot.RobotMover;
import h04.selection.KeyboardFieldSelector;
import h04.selection.MouseFieldSelector;
import h04.strategy.MoveByTeleport;
import h04.strategy.MoveByWalk;


/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int numberOfRows = 10;
        int numberOfColumns = 10;

        World.setSize(numberOfColumns, numberOfRows);
        World.getGlobalWorld().setDrawTurnedOffRobots(false);
        World.setVisible(true);
        World.setDelay(100);
        main01();
//        main02();
    }

    public static void main01() {
        MouseFieldSelector mouseFieldSelector = new MouseFieldSelector();
        MoveByWalk moveByWalk = new MoveByWalk();
        RobotMover robotMover = new RobotMover(moveByWalk);
        mouseFieldSelector.setFieldSelectionListener(robotMover);
        Robot robot1 = new Robot(1, 1, Direction.UP, 0);
        Robot robot2 = new Robot(3, 2, Direction.DOWN, 0);
        Robot robot3 = new Robot(5, 5, Direction.LEFT, 0);
        robotMover.addRobot(robot1);
        robotMover.addRobot(robot2);
        robotMover.addRobot(robot3);
    }

    public static void main02() {
        KeyboardFieldSelector keyboardFieldSelector = new KeyboardFieldSelector();
        MoveByTeleport moveByTeleport = new MoveByTeleport();
        MoveableRobot moveableRobot = new MoveableRobot(moveByTeleport);
        keyboardFieldSelector.setFieldSelectionListener(moveableRobot);
    }
}
