package model.strategyPattern;

import controller.App;
import model.Direction;
import model.SnakeNode;

public class AutomaticStrategy implements PlayStrategy{

	@Override
	public void move() {
		
		SnakeNode head = App.model.snake.nodes.get(0);
		int foodX = App.model.food.x;
		int foodY = App.model.food.y;

		if (head.x < foodX) {
            App.model.snake.setDirection(Direction.RIGHT);
        } else if (head.x > foodX) {
            App.model.snake.setDirection(Direction.LEFT);
        } else if (head.y < foodY) {
            App.model.snake.setDirection(Direction.DOWN);
        } else if (head.y > foodY) {
            App.model.snake.setDirection(Direction.UP);
        }

        App.model.snake.move();
    }
	}
	

