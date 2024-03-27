package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------");

        List<String[][]> robots = new ArrayList<>();
        int[] mars = {5,3};

        /*
         *  Create Robots
         *  first{} : { position }
         *  second{} : { instruction }
         */
        String[][] robot_one = {{"1", "1", "E"},{"R","F","R","F","R","F","R","F"}};
        String[][] robot_two = {{"3", "2", "N"},{"F","R","R","F","L","L","F","F","R","R","F","L","L"}};
        String[][] robot_three = {{"0", "3", "W"},{"L","L","F","F","F","L","F","L","F","L"}};
        String[][] robot_four = {{"1", "3", "E"}, {"F","R","R","F","L","L","L","F"}};
        String[][] robot_five = {{"4", "3", "N"}, {"L","F","R","F","L","F","F","R","F"}};
        /*
         *  Add Robots to List
         */
        robots.add(robot_one);
        robots.add(robot_two);
        robots.add(robot_three);
        robots.add(robot_four);
        robots.add(robot_five);

        /*
         * Pass mars & robots as parameters and execute
         */

        String result = new RobotChallenge().multiRobots(mars, robots);
        System.out.println("Output : \n" + result );

    }

}
