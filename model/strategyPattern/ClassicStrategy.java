package model.strategyPattern;

import controller.App;

public class ClassicStrategy implements PlayStrategy{

	@Override
	public void move() {
		App.model.snake.move();
	}
	
}
