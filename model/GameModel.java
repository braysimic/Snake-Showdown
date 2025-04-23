package model;

import java.util.Random;

import controller.App;
import model.strategyPattern.ClassicStrategy;
import model.strategyPattern.PlayStrategy;
import view.AppCanvas;
import view.AppWindow;

public class GameModel {
	
	public Snake snake;
	public Food food;
	public String messages;
	public int score;

	private PlayStrategy playStrategy;

	public GameModel() {
		snake = new Snake();
		setPlayStrategy(new ClassicStrategy());
		init();
	}

	public void setPlayStrategy(PlayStrategy strategy) {
		this.playStrategy = strategy;
	}

	public void playMove() {
		if(playStrategy != null) {
			playStrategy.move();
		}
	}

	public void init() {
		snake.init();
		score = 0;
		messages = "Click <Start> to Play";
		food = createFood();
	}

	public Food createFood() {
		Random random = new Random();
		int x, y;
		do {
		x = random.nextInt(AppCanvas.WIDTH / AppWindow.GRID_SIZE)  * AppWindow.GRID_SIZE;
		y = random.nextInt(AppCanvas.HEIGHT / AppWindow.GRID_SIZE)  * AppWindow.GRID_SIZE;
		} while(isInsideSnake(x, y));
		return new Food(x, y);
	}
	private boolean isInsideSnake(int x, int y) {
		for (var node: snake.nodes) {
			if(node.x == x && node.y == y) return true;
		}

		return false;
	}

	public boolean snakeGotFood() {
		var food = App.model.food;
		var head = App.model.snake.nodes.get(0);
		return food.x == head.x && food.y == head.y;
	}

	public boolean snakeLeftScene() {
		var head = App.model.snake.nodes.get(0);
		return head.x <= 0 || head.x >= AppCanvas.WIDTH
		|| head.y <= 0 || head.y >= AppCanvas.HEIGHT;
	}

	public boolean snakeHitsItsBody() {
		var nodes = App.model.snake.nodes;
		var head = nodes.get(0);
		for (int i = 1; i < nodes.size(); i++) {
			var n = nodes.get(i);
			if(head.x == n.x && head.y == n.y) return true;
		}
		return false;
	}

	public void reset() {
		init();
	}
}
