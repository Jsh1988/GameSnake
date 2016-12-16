package main.com.jsh.gamesnake.object;

import main.com.jsh.gamesnake.main.GameSnake;

public class Snake {
    public int direction = 0;
    public int length = 2;

    public int snakeX[] = new int[GameSnake.WIDTH*GameSnake.HEIGHT];
    public int snakeY[] = new int[GameSnake.WIDTH*GameSnake.HEIGHT];

    public Snake(int x0, int y0, int x1, int y1){
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    @SuppressWarnings("static-access")
    public void move(){

        for(int obj = length; obj > 0; obj--){
            snakeX[obj] = snakeX[obj-1];
            snakeY[obj] = snakeY[obj-1];
        }

        if(direction == 0) snakeX[0]++;
        if(direction == 1) snakeY[0]++;
        if(direction == 2) snakeX[0]--;
        if(direction == 3) snakeY[0]--;

        for (int obj = length-1; obj > 0; obj--){
            if( (snakeX[0]==snakeX[obj]) & (snakeY[0] == snakeY[obj]) ) length = obj-2;
        }

        if(snakeX[0] > GameSnake.WIDTH ) snakeX[0]=0;
        if(snakeX[0] < 0 ) snakeX[0] = GameSnake.WIDTH-1;
        if(snakeY[0] > GameSnake.HEIGHT-1 ) snakeY[0]=0;
        if(snakeY[0] < 0 ) snakeY[0] = GameSnake.HEIGHT-1;

        if(length < 2) length=2;

    }
}
