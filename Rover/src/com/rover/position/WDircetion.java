package com.rover.position;
public class WDircetion implements Direction {

	public void turnLeft(Rover position) {
		position.setDirection(new SDircetion());
	}

	public void turnRight(Rover position) {
		position.setDirection(new NDircetion());
	}

	public String getName() {
		return "W";
	}

	public void move(Coordinate c) {
		c.setX(c.getX() - 1);
	}

}
