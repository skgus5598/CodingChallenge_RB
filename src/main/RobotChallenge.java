package main;

public class RobotChallenge {
    public String findPositions(int[] mars, String[] coordinates, String[] positions){
        String result = "";
        /*
            5 3
            0 3 W
            LLFFFLFLFL
         */
        //Dead Line : x=5, y=3, x=4&y=0 or y=3
        int[] scent = new int[2]; // dead coordinates
        int [] location = {Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])}; // horse
        //location { 1, 1 }
        String facing = coordinates[2]; // W
        String[] sides = { "E", "S", "W", "N"};
        int facingIdx = 0;

        for(int i=0; i < sides.length; i++){
            if(facing.equals(sides[i])){
                facingIdx = i; // 2
                System.out.println("facingidx : " + i +", " + facing);
                break;
            }
        }

        //LL FFF LFLFL
        for(int i=0; i < positions.length; i++) {
            System.out.println("??" + positions[i] );
            if(positions[i].equals("R")){
                facingIdx ++;
                if(facingIdx == 4) facingIdx = 0;
                facing = sides[facingIdx];
                System.out.println("turn right : " + facing);
            }else if(positions[i].equals("L")){
                facingIdx --;
                if(facingIdx == -1) facingIdx = 3;
                facing = sides[facingIdx];
                System.out.println("turn left : " + facing + " , facing idx : " + facingIdx);
            }else if(positions[i].equals("F")){
                //moving forward
                    if(facing.equals("E")){ // x+1
                        location[0] ++;
                        System.out.println("E) X+1 :" + location[0]);
                    }else if(facing.equals("S")){ //y-1
                        location[1] --;
                        System.out.println("S) Y-1 :" + location[1]);
                    }else if(facing.equals("W")){ //x-1
                        location[0] --;
                        System.out.println("W) X-1 :" + location[0]);
                    }else{ //N y+1
                        location[1] ++;
                        System.out.println("N) Y+1 :" + location[1]);
                    }
            }
        }
        System.out.println("location[0] : " + location[0] + ", location[1] : " + location[1]+ ", facing : " + facing);
        result = location[0] + " " + location[1] + " " + facing;
        System.out.println("result : " + result);


        return result  ;

    }
}
