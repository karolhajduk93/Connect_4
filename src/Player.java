public class Player {
    static boolean tour = true; //true - player 1(red), false - player 2(blue) (tours)
    boolean win = false;
    static int counterRed = 0, counterBlue = 0;

    public void move(int column){
        if(Game.circles[column].contains(0)) {
            for (int i = Game.circles[column].size() - 1; i >= 0; i--) {
                if (Game.circles[column].get(i) == 0) {
                    if (tour)
                        Game.circles[column].set(i, 1);
                    else
                        Game.circles[column].set(i, 2);
                    break;
                }
            }
            Player.tour = !Player.tour;
        }
    }

    public static int winCondition(){
        //if red win return - 1 if blue - 2 if draw - 3

        counterRed = 0; counterBlue = 0;
        //checking ROWS
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++) {
                circleCheck(Game.circles[j].get(i));
            }
        }

        counterBlue = 0; counterRed = 0;
        //checking COLUMNS
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                circleCheck(Game.circles[i].get(j));
            }
        }

        //checking DIAGONALS

        // from up-right to down-left (1/2)
        for(int i = 3; i >= 0; i--) {
            for (int x = i, y = 0; x < 7 && y < 6; x++, y++) {
                circleCheck(Game.circles[x].get(y));
            }
        }
        // from up-right to down-left (2/2)
        for(int i = 1; i < 3; i++) {
            for (int x = 0, y = i; y < 6; x++, y++){
                circleCheck(Game.circles[x].get(y));
            }
        }

        //from up-left to down-right (1/2)
        for(int i = 3; i < 7; i++){
            for(int x = i, y = 0; x >=0 && y < 6; y++, x--){
                circleCheck(Game.circles[x].get(y));
            }
        }
        //from up-left to down-right (2/2)
        for(int i = 1; i < 3; i++){
            for (int x = 6, y = i; y < 6; x--, y++){
                circleCheck(Game.circles[x].get(y));
            }
        }
        return 0;
    }

    public static void circleCheck(int circle){
        if(circle == 1) { //RED
            counterBlue = 0;
            counterRed++;
            if(counterRed == 4)
                System.out.println("Game won by red player!!!!");
        }
        else if(circle == 2) { //BLUE
            counterRed = 0;
            counterBlue++;
            if (counterBlue == 4)
                System.out.println("Game won by blue player!!!!");
        }
        else {
            counterRed = 0;
            counterBlue = 0;
        }
    }
}

