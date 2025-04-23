package view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.ButtonPressListener;
import controller.KeyPressListener;
import model.strategyPattern.AutomaticStrategy;
import view.statePattern.GameState;
import view.statePattern.GameStateInit;

public class AppWindow extends JFrame{

	private AppCanvas canvas;

	public static final int GRID_SIZE = 20;

	public JButton startPauseButton;
	public JButton restartButton;
	public JButton exitButton;
	public static final String START_ACTION = "Start";
	public static final String PAUSE_ACTION = "Pause";
	public static final String RESTART_ACTION = "App Restart";
	public static final String EXIT_ACTION = "Exit";

	private GameState gameState;

	private JRadioButton classicModeButton;
	private JRadioButton automaticModeButton;
	private ButtonGroup strategyGroup;
	
	public void init() {
		Container cp = getContentPane();
		canvas = new AppCanvas();
		cp.add(canvas, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		startPauseButton = new JButton(START_ACTION);
		restartButton = new JButton(RESTART_ACTION);
		exitButton = new JButton(EXIT_ACTION);
		southPanel.add(startPauseButton);
		southPanel.add(restartButton);
		southPanel.add(exitButton);

		classicModeButton = new JRadioButton("Classic Mode");
		automaticModeButton = new JRadioButton("Automatic Mode");
		strategyGroup = new ButtonGroup();
		strategyGroup.add(classicModeButton);
		strategyGroup.add(automaticModeButton);

		classicModeButton.setSelected(true);

		southPanel.add(classicModeButton);
		southPanel.add(automaticModeButton);

		cp.add(BorderLayout.SOUTH, southPanel);

		ButtonPressListener buttonPressListener = new ButtonPressListener();
		startPauseButton.addActionListener(buttonPressListener);
		restartButton.addActionListener(buttonPressListener);
		exitButton.addActionListener(buttonPressListener);
		
		KeyPressListener keyPressListener = new KeyPressListener();
		canvas.addKeyListener(keyPressListener);
		canvas.requestFocusInWindow();
		canvas.setFocusable(true);

		startPauseButton.setFocusable(false);
		restartButton.setFocusable(false);
		exitButton.setFocusable(false);
		classicModeButton.setFocusable(false);
		automaticModeButton.setFocusable(false);

		gameState = new GameStateInit();
	}

	public void setStrategyButtonsEnabled(boolean enabled) {
		classicModeButton.setEnabled(enabled);
		automaticModeButton.setEnabled(enabled);
	}
	

	public void goNextState() {
		gameState.goNext(this);
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public AppCanvas getCanvas() {
		return canvas;
	}

	public boolean isAutomaticModeSelected() {
		return automaticModeButton.isSelected();
	}
}
