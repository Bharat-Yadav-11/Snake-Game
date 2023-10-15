# Snake-Game

This readme provides an overview of the Snake Game code and its functionality. The Snake Game is a simple game implemented in Java using Swing for the graphical interface.

## Table of Contents
- [Introduction](#introduction)
- [Installation](#installation)
- [How to Play](#how-to-play)
- [Code Structure](#code-structure)
- [Acknowledgments](#acknowledgments)

## Introduction

The Snake Game is a classic arcade game where the player controls a snake that moves around the screen and tries to eat apples to grow. The objective of the game is to collect as many apples as possible without colliding with the walls or the snake's own body. The game features simple graphics and keyboard controls for the snake's movement.

## Installation

To run the Snake Game, follow these steps:

1. Ensure you have Java installed on your computer.

2. Download the Snake Game source code or compile it from the provided code.

3. Open a terminal or command prompt.

4. Navigate to the directory containing the `Board.java` file.

5. Compile the code using the following command:
   ```shell
   javac Board.java
   ```

6. Run the game with the following command:
   ```shell
   java SnakeGame.Board
   ```

7. The game window should open, and you can start playing.

## How to Play

- Use the arrow keys (Up, Down, Left, Right) or the 'W', 'S', 'A', 'D' keys to control the snake's movement.

- The snake will continuously move in the direction it's facing.

- Collect apples by moving the snake's head over them to increase your score and the snake's length.

- Avoid running into the walls or colliding with the snake's own body. Collisions will end the game.

- The game will display a "Game Over" message when you lose. You can restart the game by closing and rerunning it.

## Code Structure

The Snake Game code consists of a single Java class, `Board`, which extends the `JPanel` class and implements the `ActionListener` interface. Here's an overview of the code structure:

- **Instance Variables**: These variables store information about the game, such as the snake's position, apple location, game state, and images used for drawing.

- **Constructor**: The `Board` constructor initializes the game, sets up key listeners, and loads the images.

- **loadImages()**: Loads the images for the apple, snake head, and snake body.

- **initGame()**: Initializes the game state, including the snake's initial position, length, and starting an update timer.

- **locateApple()**: Randomly positions the apple within the game board.

- **paintComponent(Graphics g)**: Draws the game components, including the snake, apple, and game over message.

- **move()**: Updates the snake's position based on the current direction.

- **checkApple()**: Checks if the snake has eaten an apple and increases the score and snake length accordingly.

- **checkCollision()**: Checks for collisions with the walls or the snake's own body, ending the game if a collision is detected.

- **actionPerformed(ActionEvent e)**: Handles game updates based on the timer, including checking for apple collection, collisions, and moving the snake.

- **TAdapter inner class**: This inner class extends `KeyAdapter` and handles keyboard input for controlling the snake's movement.

## Acknowledgments

This Snake Game code is a simple implementation of the classic game and serves as a great starting point for those interested in Java game development. The code can be extended and improved upon with additional features and enhancements. Thank you for playing!
