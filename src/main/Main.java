package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------------");
        int[] mars = {5,3};
        String[] coordinate = { "3", "2", "N"};
        String[] positions = { "L","L","F","F","F","L","F","L","F","L"};
        String[] positions2 = {"F","R","R","F","L","L","F","F","R","R","F","L","L"};
        String  result = new RobotChallenge().findPositions(mars, coordinate, positions2);
        System.out.println("-----------------------------------");



    }
}
