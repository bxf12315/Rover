package com.rover.main;

import java.util.HashMap;
import java.util.Scanner;

import com.rover.action.Action;
import com.rover.position.*;

public class RemoteControl {

	private HashMap<String, String> ruleMap;
	private HashMap<String, String> dircetionMap;

	public RemoteControl() {
		ruleMap = new HashMap<String, String>();
		ruleMap.put("L", "com.rover.action.TurnLeft");
		ruleMap.put("R", "com.rover.action.TurnRight");
		ruleMap.put("M", "com.rover.action.Move");

		dircetionMap = new HashMap<String, String>();
		dircetionMap.put("E", "com.rover.position.EDircetion");
		dircetionMap.put("N", "com.rover.position.NDircetion");
		dircetionMap.put("S", "com.rover.position.SDircetion");
		dircetionMap.put("W", "com.rover.position.WDircetion");

	}

	private String[] analyzeCommands(String commands) {
		char[] cs = commands.toCharArray();
		String[] results = new String[cs.length];
		for (int i = 0; i < cs.length; i++) {
			results[i] = cs[i] + "";
		}
		return results;
	}

	private Rover initCoordinate(String init) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		String[] coordinate = init.split(",");

		Coordinate c = new Coordinate(Integer.parseInt(coordinate[0]),
				Integer.parseInt(coordinate[1]));
		Direction direction = (Direction) Class.forName(
				dircetionMap.get(coordinate[2])).newInstance();
		Rover rover = new Rover(c, direction);
		return rover;
	}

	public Rover excute(String input, String initCoordinate) {

		String[] commands = analyzeCommands(input);
		Rover rover = null;
		try {
			rover = initCoordinate(initCoordinate);
			System.out.println("Rover's initCoordinate = " + rover.toString());

			for (int i = 0; i < commands.length; i++) {

				Action action = (Action) Class
						.forName(ruleMap.get(commands[i])).newInstance();
				action.doing(rover);
				System.out.println("Rover's CurrentCoordinate = "
						+ rover.toString());
			}

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Rover's finallyCoordinate = " + rover.toString());
		return rover;
	}

	public static void main(String[] args) {
		RemoteControl rc = new RemoteControl();
		String input = "";
		String initCoordinate = "";
		System.out.println("please input init Coordinate:(like 1,1,N)");
		Scanner scCoordinate = new Scanner(System.in);
		initCoordinate = scCoordinate.next();
		System.out.println("please input commands:");
		input = scCoordinate.next();
		scCoordinate.close();

		rc.excute(input, initCoordinate);

	}
}
