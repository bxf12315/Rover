package com.rover.position;
public class EDircetion implements Direction {

	public void turnLeft(Rover position) {
		position.setDirection(new NDircetion());
	}

	public void turnRight(Rover position) {
		position.setDirection(new SDircetion());
	}

	public String getName() {
		return "E";
	}

	public void move(Coordinate c) {
		c.setX(c.getX() + 1);
	}

}
