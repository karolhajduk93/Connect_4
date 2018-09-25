public class Player {
    static boolean tour = true; //true - player 1(red), false - player 2(blue) (tours)
    boolean win = false;


    public Player(){
    }


    public void move(int column){
        // zmiana kolka na kolor (po to jest player statyczny) - 1red, 2blue
        //inwokuj metode winCondition by sprawdzic czy wygral (????????????)
        System.out.println(column);

        for(int i = Game.circles[column].size() - 1 ; i >= 0; i--){
            if(Game.circles[column].get(i) == 0){
                if(tour)
                    Game.circles[column].set(i, 1);
                else
                    Game.circles[column].set(i, 2);
                break;
            }
        }

    }
}

