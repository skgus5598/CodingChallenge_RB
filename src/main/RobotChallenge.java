package main;
import java.util.ArrayList;
import java.util.List;

public class RobotChallenge {

    public String multiRobots(int[] mars, List<String[][]> robots) {
        String result = "";

        //Store scent position
        List<int[]> scentList = new ArrayList<>();
        scentList.add(new int[]{-1,-1}); //Initialize temporary default scent position

        ArrayList<int[]> tempList = new ArrayList<>();


        String scentSt = ""; //Scent status : "" or "LOST"
        String[] directions = {"E", "S", "W", "N"};
        String curr_direction = ""; // Current direction

        for (String[][] robot : robots) {
            //Set default values for each robot's status
            scentSt = "";
            int[] location = new int[]{Integer.parseInt(robot[0][0]), Integer.parseInt(robot[0][1])};
            curr_direction = robot[0][2];
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
                    int cnt = 0;
                    for(int[] scent : scentList){
                        if (curr_direction.equals("E")) { // Move East (x+1)
                            if(location[0]+1 != scent[0] || location[1] != scent[1]) { // Check if location meets scent
                                cnt ++;
                                if(cnt == scentList.size()){ // Check all scentList and if it doesn't meet, then move
                                    location[0]++;
                                }
                            }
                        } else if (curr_direction.equals("S")) { //( Move South (y-1)
                            if(location[0] != scent[0] || location[1]-1 != scent[1]) {
                                cnt++;
                                if(cnt == scentList.size()){
                                    location[1]--;
                                }
                            }
                        } else if (curr_direction.equals("W")) { // Move West (x-1)
                            if(location[0]-1 != scent[0] || location[1] != scent[1]) {
                                cnt++;
                                if(cnt == scentList.size()){
                                    location[0]--;
                                }
                            }
                        } else { // Move North (y+1)
                            if(location[0] != scent[0] || location[1]+1 != scent[1]) {
                                cnt++;
                                if(cnt == scentList.size()){
                                    location[1]++;
                                }
                            }
                        }
                    }
                    // Check if robot's location is out of the grid
                    if(location[0] > mars[0] || location[1] > mars[1]){
                        for(int[] scent : scentList){
                            if(location[0] != scent[0] || location[1] != scent[1]){ // Prevent duplication
                                tempList.add(new int[]{location[0], location[1]});
                                scentSt = "LOST";
                            }
                        }
                        for(int[] temp : tempList){
                            scentList.add(temp);
                        }
                    }
                }
            }
            // Append the result
            result += location[0] + " " + location[1] + " " + curr_direction + " " + scentSt.trim() + "\n";
        }

        return result;
    }
}
