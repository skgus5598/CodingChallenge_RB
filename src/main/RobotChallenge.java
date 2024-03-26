package main;

import java.util.List;

public class RobotChallenge {
/*
    public String findPositions(int[] mars, String[] coordinates, String[] positions){
        String result = "";

        //Scent zone
        int[] scent = {0,0}; // initialize
        String scentN = ""; // "" or "LOST"

        //Initialize robot's location
        int [] location = {Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};


        String facing = coordinates[2]; //facing side
        String[] sides = { "E", "S", "W", "N"};
        int facingIdx = 0;

        for(int i=0; i < sides.length; i++){ // set up by idx
            if(facing.equals(sides[i])){
                facingIdx = i;
                break;
            }
        }

        //LL FFF LFLFL
        for(int i=0; i < positions.length; i++) {
            if(positions[i].equals("R")){
                facingIdx ++;
                if(facingIdx == 4) facingIdx = 0;
                facing = sides[facingIdx];
            }else if(positions[i].equals("L")){
                facingIdx --;
                if(facingIdx == -1) facingIdx = 3;
                facing = sides[facingIdx];
            }else if(positions[i].equals("F")){
                //moving forward
                    if(facing.equals("E")){ // x+1
                        location[0] ++;
                    }else if(facing.equals("S")){ //y-1
                        location[1] --;
                    }else if(facing.equals("W")){ //x-1
                        location[0] --;
                    }else{ //N :: y+1
                        location[1] ++;
                    }
            }
        }
        //scent test
        if(location[0] >= 0 && location[0] <=mars[0]){
            if(location[0] == 0 || location[0] == mars[1]){
                scent[0] = location[0];
                scent[1] = location[1];
                scentN = "LOST";
            }
        }
        result = location[0] + " " + location[1] + " " + facing + " " + scentN;
        System.out.println("result : " + result);
        return result.trim()  ;
    }

*/
    public String multiRobots(int[] mars, List<RobotDTO> robotList) {
        String result = "";

        //Scent zone
        int[] scent = {0, 0}; // initialize
        String scentN = ""; // "" or "LOST"
        String[] sides = {"E", "S", "W", "N"};
        int[] location = new int[2];
        String facing = "";

        for (RobotDTO robot : robotList) {//
            scentN = "";
            location = new int[]{Integer.parseInt(robot.getCoordinate()[0]), Integer.parseInt(robot.getCoordinate()[1])};
            facing = robot.getCoordinate()[2];
            int facingIdx = 0;

            for (int i = 0; i < sides.length; i++) {
                if (facing.equals(sides[i])) {
                    facingIdx = i;
                    break;
                }
            }

            for (String position : robot.getPosition()) {
                if (position.equals("R")) {
                    facingIdx++;
                    if (facingIdx == 4) facingIdx = 0;
                    facing = sides[facingIdx];
                } else if (position.equals("L")) {
                    facingIdx--;
                    if (facingIdx == -1) facingIdx = 3;
                    facing = sides[facingIdx];
                } else if (position.equals("F")) {
                    //moving forward
                    if (facing.equals("E")) { // x+1
                        location[0]++;
                    } else if (facing.equals("S")) { //y-1
                        location[1]--;
                    } else if (facing.equals("W")) { //x-1
                        location[0]--;
                    } else { //N :: y+1
                        location[1]++;
                    }

                }
            }
            //scent test
            if (location[0] >= 0 && location[0] <= mars[0]) {
                if (location[0] == 0 || location[0] == mars[1]) {
                    scent[0] = location[0];
                    scent[1] = location[1];
                    scentN = "LOST";
                }
            }
            result += location[0] + " " + location[1] + " " + facing + " " + scentN + "\n";

        }


        System.out.println("result : " + result);
        return result.trim();
    }
}
