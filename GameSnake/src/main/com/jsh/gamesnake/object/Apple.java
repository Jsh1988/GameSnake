package main.com.jsh.gamesnake.object;

import main.com.jsh.gamesnake.main.GameSnake;

public class Apple {

    GameSnake gameSnake;

    public int posX;
    public int posY;

    public Apple(int startX, int startY){
        posX = startX;
        posY = startY;
    }

    @SuppressWarnings("static-access")
    public void setRandomPosition(){
        posX = (int) (Math.random()* GameSnake.WIDTH);
        posY = (int) (Math.random()* GameSnake.HEIGHT);
    }

}
