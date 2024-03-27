package test;

import main.RobotChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotChallengeTest {


    @Test
    public void testMultiRobots(){
        RobotChallenge robotChallenge = new RobotChallenge();
        //Given
        int[] mars = {5,3};
        List<String[][]> robots = new ArrayList<>();

        robots.add(new String[][]{{"1", "1", "E"},{"R","F","R","F","R","F","R","F"}});
        robots.add(new String[][]{{"3", "2", "N"},{"F","R","R","F","L","L","F","F","R","R","F","L","L"}});
        robots.add(new String[][]{{"0", "3", "W"},{"L","L","F","F","F","L","F","L","F","L"}});
        //robots.add(new String[][]{{"1", "3", "E"}, {"F","R","R","F","L","L","L","F"}});
        //robots.add(new String[][]{{"4", "3", "N"}, {"L","F","R","F","L","F","F","R","F"}});


        //When
        String expected = "1 1 E \n3 3 N LOST\n2 3 S \n";
        String actual = robotChallenge.multiRobots(mars, robots);

        //Then
        assertEquals(expected, actual);
    }
}