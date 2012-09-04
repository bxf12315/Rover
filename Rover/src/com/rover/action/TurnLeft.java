package com.rover.action;

import com.rover.position.Rover;


public class TurnLeft implements Action {

	public void doing(Rover p) {
		p.turnLeft();		
	}

}
