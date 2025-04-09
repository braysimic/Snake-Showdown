package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStateOver implements GameState{

	public GameStateOver() {
		App.win.restartButton.setEnabled(false);
		App.win.startPauseButton.setEnabled(true);
	}

	@Override
	public void goNext(AppWindow context) {
		context.setGameState(new GameStateInit());
	}

	@Override
	public void animate() {
		
	}
	
}
