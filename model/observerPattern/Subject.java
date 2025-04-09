package model.observerPattern;

public interface Subject {
	
	void addObserver(SnakeObserver o);
	void removeObsever(SnakeObserver o);
	void notifyObsever(SnakeEvent e);
}
