package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------");

        List<RobotDTO> robotList = new ArrayList<>();
        int[] mars = {5,3};

        RobotDTO robot1 = new RobotDTO();
        robot1.setCoordinate(new String[]{ "1", "1", "E"});
        robot1.setPosition(new String[]{ "R","F","R","F","R","F","R","F"});

        RobotDTO robot2 = new RobotDTO();
        robot2.setCoordinate(new String[]{ "3", "2", "N"});
        robot2.setPosition(new String[]{"F","R","R","F","L","L","F","F","R","R","F","L","L"});

        RobotDTO robot3 = new RobotDTO();
        robot3.setCoordinate(new String[]{ "0", "3", "W"});
        robot3.setPosition(new String[]{ "L","L","F","F","F","L","F","L","F","L"});

        robotList.add(robot1);
        robotList.add(robot2);
        robotList.add(robot3);

        new RobotChallenge().multiRobots(mars, robotList);

      //  String  result = new RobotChallenge().findPositions(mars, coordinate_a, positions_a);
        System.out.println("-----------------------------------");

    }

}
