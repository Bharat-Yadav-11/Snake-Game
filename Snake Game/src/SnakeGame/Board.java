package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {
    private Image apple;
    private Image dot;
    private Image head;

    private final int ALL_DOTS = 2500;
    private final int DOT_SIZE = 10;
    final int RANDOM_POSITION = 29;
    private int apple_x;
    private int apple_y;

    private final int[] x = new int[ALL_DOTS];
    private final int[] y = new int[ALL_DOTS];

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;

    public boolean inGame = true;
    private int dots;
    private Timer timer;
    private int VALUE = 0;
    private JButton restart;

    Board(){
        addKeyListener(new TAdapter());

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(500,500));
        setFocusable(true);

        loadImages();
        initGame();
    }
    public void loadImages(){
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/apple.png"));
    apple = i1.getImage();
    ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/dot.png"));
    dot = i2.getImage();
    ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("SnakeGame/icons/head.png"));
    head = i3.getImage();
    }

    public void initGame() {
        dots = 3;
        for(int i=0; i<dots; i++){
            y[i] = 50;
            x[i] = 50 - i * DOT_SIZE;

        }
        locateApple();

        timer = new Timer(140, this);
        timer.start();
    }


    public void locateApple() {
       int r = (int) (Math.random() * RANDOM_POSITION);
       apple_x = r*DOT_SIZE;

       r = (int) (Math.random() * RANDOM_POSITION);
       apple_y = r*DOT_SIZE;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }
    public void draw(Graphics g) {
        if(inGame) {
            g.drawImage(apple, apple_x, apple_y, this);

            for(int i=0; i<dots; i++) {
                if (i == 0) {
                    g.drawImage(head, x[i], y[i], this);
                } else {
                    g.drawImage(dot, x[i], y[i], this);
                }
                Toolkit.getDefaultToolkit().sync();
            }
            score(g);

        } else {
            gameOver(g);
            restart = new JButton("Restart");
            restart.setBounds(200, 225, 100, 30);
            restart.setBackground(Color.WHITE);
            restart.setForeground(Color.BLACK);
            restart.addActionListener(this);
            add(restart);
        }
    }
    public void gameOver(Graphics g) {
        String msg = "Game Over";
        Font font = new Font("SAN_SERIF", Font.BOLD, 20);
        FontMetrics metrics = getFontMetrics(font);

        g.setColor(Color.WHITE);
        g.setFont(font);

        g.drawString(msg, (500 - metrics.stringWidth(msg)) / 2, 400/2);
    }

    public void score(Graphics s){
        String msg = "Score : " + VALUE;
        Font font = new Font("SAN_SERIF", Font.BOLD, 20);

        s.setColor(Color.WHITE);
        s.setFont(font);
        s.drawString(msg, 210, 20);
    }

    public void move() {
        for(int i=dots; i>0; i--){
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if(leftDirection) {
            x[0] = x[0] - DOT_SIZE;
        }
        if(rightDirection) {
            x[0] = x[0] + DOT_SIZE;
        }
        if(upDirection) {
            y[0] = y[0] - DOT_SIZE;
        }
        if(downDirection) {
            y[0] = y[0] + DOT_SIZE;
        }

    }
    public void checkApple() {
        if((x[0] == apple_x) && (y[0] == apple_y)){
            dots++;
            locateApple();
            VALUE++;
        }
    }
    public void checkCollision(){
        for(int i=dots; i>0; i--){
            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
                break;
            }
        }
        if(y[0] >= 500) {
            inGame = false;
        }
        if(x[0] >= 500) {
            inGame = false;
        }
        if(y[0] < 0) {
            inGame = false;
        }
        if(x[0] < 0) {
            inGame = false;
        }
        if(!inGame) {
            timer.stop();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame) {
            checkApple();
            checkCollision();
            move();
        } else if (e.getSource() == restart) {
            setVisible(false);
            new SnakeGame().setVisible(true);
        }
        repaint();
    }
    public class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_LEFT && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if(key == KeyEvent.VK_RIGHT && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if(key == KeyEvent.VK_UP && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            if(key == KeyEvent.VK_DOWN && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }


            if(key == KeyEvent.VK_A && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if(key == KeyEvent.VK_D && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if(key == KeyEvent.VK_W && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            if(key == KeyEvent.VK_S && (!upDirection)) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }

        }
    }







}
