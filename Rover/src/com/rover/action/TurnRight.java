package com.rover.action;

import com.rover.position.Rover;


public class TurnRight implements Action {

	public void doing(Rover p) {
		p.turnRight();		
	}

}
