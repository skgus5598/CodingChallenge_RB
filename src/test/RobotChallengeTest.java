package test;

import main.RobotChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotChallengeTest {


    @Test
    public void test_one(){
        //Given
        int[] mars = {5,3};
        String[] coordinate = { "1", "1", "E"};
        String[] positions_a = { "R","F","R","F","R","F","R","F"};

        //When
        String expected = "1 1 E";
        String actual = new RobotChallenge().findPositions(mars, coordinate, positions_a) ;
        //Then
        assertEquals(expected, actual);
    }
    @Test
    public void test_all(){
        //Given
        int[] mars = {5, 3};
        String[] coordinate_a = { "1", "1", "E"};
        String[] positions_a = { "R","F","R","F","R","F","R","F"};

        String[] coordinate_b = { "3", "2", "N"};
        String[] positions_b = {"F","R","R","F","L","L","F","F","R","R","F","L","L"};

        String[] coordinate_c = { "0", "3", "W"};
        String[] positions_c = { "L","L","F","F","F","L","F","L","F","L"};

        //When
        String expected_a = "1 1 E";
        String expected_b = "3 3 N LOST";
        String expected_c = "2 3 S";

        //Then
        assertAll(
                () -> assertEquals(expected_a, new RobotChallenge().findPositions(mars, coordinate_a, positions_a)),
                () -> assertEquals(expected_b, new RobotChallenge().findPositions(mars, coordinate_b, positions_b)),
                () -> assertEquals(expected_c, new RobotChallenge().findPositions(mars, coordinate_c, positions_c))
        );
    }
}