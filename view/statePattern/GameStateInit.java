package view.statePattern;

import controller.App;
import model.Snake;
import model.strategyPattern.AutomaticStrategy;
import model.strategyPattern.ClassicStrategy;
import view.AppCanvas;
import view.AppWindow;

public class GameStateInit implements GameState{

	public GameStateInit() {
		App.win.startPauseButton.setText(AppWindow.START_ACTION);
		App.win.restartButton.setEnabled(false);
		App.win.startPauseButton.setEnabled(true);
		// App.model.init();
	}

	@Override
	public void goNext(AppWindow context) {
		// context.setGameState(new GameStatePlaying());

		if(context.isAutomaticModeSelected()) {
			App.model.setPlayStrategy(new AutomaticStrategy());
		} else {
			App.model.setPlayStrategy(new ClassicStrategy());
		}

		App.model.init();
		App.model.messages = "";


		context.startPauseButton.setText(AppWindow.PAUSE_ACTION);
		context.restartButton.setEnabled(true);

		App.win.setStrategyButtonsEnabled(true);

		
		App.timer.start();
		context.setGameState(new GameStatePlaying());

		context.getCanvas().repaint();
	}

	@Override
	public void animate() {
		
	}
	
}
