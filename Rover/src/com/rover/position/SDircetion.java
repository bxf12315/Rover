package com.rover.position;
public class SDircetion implements Direction {

	public void turnLeft(Rover position) {
		position.setDirection(new EDircetion());
	}

	public void turnRight(Rover position) {
		position.setDirection(new WDircetion());
	}

	public String getName() {
		return "S";
	}

	public void move(Coordinate c) {
		c.setY(c.getY() - 1);
	}

}
