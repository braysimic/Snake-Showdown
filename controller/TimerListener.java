package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		App.model.snake.move();
		App.win.getCanvas().repaint();
	}
	
}
