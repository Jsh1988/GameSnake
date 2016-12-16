package main.com.jsh.gamesnake.main;

import main.com.jsh.gamesnake.object.Apple;
import main.com.jsh.gamesnake.object.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameSnake extends JPanel implements ActionListener {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private static final int SPEED = 5;

    Apple apple = new Apple((int)(Math.random()*WIDTH),(int)(Math.random()*HEIGHT));
    Snake snake = new Snake(10,10,9,10);
    Timer timer = new Timer(5000/SPEED, this);

    public GameSnake(){
        timer.start();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                if((key == KeyEvent.VK_RIGHT) & snake.direction != 2 ) snake.direction = 0;
                if((key == KeyEvent.VK_DOWN) & snake.direction != 3) snake.direction = 1;
                if((key == KeyEvent.VK_LEFT) & snake.direction != 0) snake.direction = 2;
                if((key == KeyEvent.VK_UP) & snake.direction != 1) snake.direction = 3;
            }
        });
        setFocusable(true);
    }

    public void paint(Graphics graphics){
        graphics.setColor(color(5,50,10));
        graphics.fillRect(0,0,WIDTH*SCALE,HEIGHT*SCALE);
        graphics.setColor(color(255,216,0));

        for(int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE ){
            graphics.drawLine(xx,0, xx,HEIGHT*SCALE);
        }

        for(int yy = 0; yy <= HEIGHT*SCALE; yy+=SCALE ){
            graphics.drawLine(0, yy,WIDTH*SCALE, yy);
        }

        for(int obj = 0; obj < snake.length; obj++ ){
            graphics.setColor(color(200, 150, 0));
            graphics.fillRect(snake.snakeX[obj]*SCALE+1, snake.snakeY[obj]*SCALE+1, SCALE-1, SCALE-1);
        }

        graphics.setColor(color(255,0,0));
        graphics.fillRect(apple.posX*SCALE+1,apple.posY*SCALE+1,SCALE-1, SCALE-1);

    }

    public Color color(int red,int green,int blue){
        return new Color(red,green,blue);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(WIDTH*SCALE+7,HEIGHT*SCALE+30);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new GameSnake());
        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        snake.move();
        if((snake.snakeX[0] == apple.posX) & (snake.snakeY[0] == apple.posY)){
            apple.setRandomPosition();
            snake.length++;
        }
        for (int obj = 1; obj < snake.length; obj++){
            if((snake.snakeX[obj] == apple.posX) & (snake.snakeY[obj] == apple.posY)){
                apple.setRandomPosition();
                snake.length++;
            }
        }
        repaint();
    }

}
