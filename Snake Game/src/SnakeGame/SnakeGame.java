package SnakeGame;

import javax.swing.*;

public class SnakeGame extends JFrame {

    SnakeGame() {
        super("Snake Game");
        this.add(new Board());
        this.pack(); // Refresh our page

        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
