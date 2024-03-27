package main;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println("-----------------------------------");

        /*
         *  Create Robots
         *  first{} : { position }
         *  second{} : { instruction }
         */
        int[] mars = {5,3};
        List<String[][]> robots = new ArrayList<>();
        robots.add(new String[][]{{"1", "1", "E"},{"R","F","R","F","R","F","R","F"}});
        robots.add(new String[][]{{"3", "2", "N"},{"F","R","R","F","L","L","F","F","R","R","F","L","L"}});
        robots.add(new String[][]{{"0", "3", "W"},{"L","L","F","F","F","L","F","L","F","L"}});
        robots.add(new String[][]{{"1", "3", "E"}, {"F","R","R","F","L","L","L","F"}});
        robots.add(new String[][]{{"4", "3", "N"}, {"L","F","R","F","L","F","F","R","F"}});

        /* Call function */
        robotChallengeFunc(mars, robots);

    }

    public static StringBuilder robotChallengeFunc(int[] mars, List<String[][]> robots){
        StringBuilder result = new StringBuilder();

        //Store scent position
        List<int[]> scentList = new ArrayList<>();
        scentList.add(new int[]{-1,-1}); //Initialize temporary default scent position

        String scentSt = ""; //Scent status : "" or "LOST"
        String[] directions = {"E", "S", "W", "N"};

        for (String[][] robot : robots) {
            //Set default values for each robot's status
            scentSt = "";
            int[] location = new int[]{Integer.parseInt(robot[0][0]), Integer.parseInt(robot[0][1])};
            String curr_direction = robot[0][2];
            int curr_direction_idx = 0;

            //Find the index of the current direction
            for (int i = 0; i < directions.length; i++) {
                if (curr_direction.equals(directions[i])) {
                    curr_direction_idx = i;
                    break;
                }
            }
            //Each movement direction of the robot
            for (String position : robot[1]) {
                if (position.equals("R")) { // Turn right
                    curr_direction_idx++;
                    if (curr_direction_idx == 4) curr_direction_idx = 0; //Rotate directions
                    curr_direction = directions[curr_direction_idx];
                } else if (position.equals("L")) { // Turn left
                    curr_direction_idx--;
                    if (curr_direction_idx == -1) curr_direction_idx = 3; //Rotate directions
                    curr_direction = directions[curr_direction_idx];
                } else if (position.equals("F")) {
                    // Move forward & avoid scent
                    if (curr_direction.equals("E")) { // Move East (x+1)
                        if(!checkMeetScent(new int[]{location[0]+1, location[1]}, scentList)){// if it's false then move
                            location[0]++;
                        }
                    } else if (curr_direction.equals("S")) { //( Move South (y-1)
                        if(!checkMeetScent(new int[]{location[0], location[1]-1}, scentList)){
                            location[1]--;
                        }
                    } else if (curr_direction.equals("W")) { // Move West (x-1)
                        if(!checkMeetScent(new int[]{location[0]-1, location[1]}, scentList)){
                            location[0]--;
                        }
                    } else { // Move North (y+1)
                        if(!checkMeetScent(new int[]{location[0], location[1]+1}, scentList)){
                            location[1]++;
                        }
                    }

                    // Check if robot's location is out of the grid => then add to scentList
                    if(location[0] > mars[0] || location[1] > mars[1] || location[0] < 0 || location[1] < 0){
                        boolean isDuplicate = false;
                        for(int[] scent : scentList){
                            if(location[0] == scent[0] && location[1] == scent[1]){ // Prevent duplication
                                isDuplicate = true;
                                break;
                            }
                        }
                        if(!isDuplicate){
                            scentList.add(new int[]{location[0], location[1]});
                            scentSt = "LOST";
                        }
                    }
                }
            }
            // Append the result
            result.append(location[0]).append(" ")
                    .append(location[1]).append(" ")
                    .append(curr_direction).append(" ")
                    .append(scentSt.trim()).append("\n");
            //result += location[0] + " " + location[1] + " " + curr_direction + " " + scentSt.trim() + "\n";
        }

        System.out.println("Output : \n" + result );
        return result;
    }

    public static boolean checkMeetScent(int[] location, List<int[]> scentList){
        for(int[] scent : scentList){
            if(location[0] == scent[0] && location[1] == scent[1]){
                return true;
            }
        }
        return false;
    }

}
