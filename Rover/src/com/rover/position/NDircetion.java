package com.rover.position;
public class NDircetion implements Direction {

	public void turnLeft(Rover position) {
		position.setDirection(new WDircetion());
	}

	public void turnRight(Rover position) {
		position.setDirection(new EDircetion());
	}

	public String getName() {
		return "N";
	}

	public void move(Coordinate c) {
		c.setY(c.getY() + 1);
	}

}
