package com.rover.position;
public interface Direction {
	void turnLeft(Rover rover);

	void turnRight(Rover rover);

	String getName();

	void move(Coordinate c);

}
