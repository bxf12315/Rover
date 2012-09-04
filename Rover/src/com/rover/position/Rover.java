package com.rover.position;

/**
 * @author bxf
 * 
 */
public class Rover {
	private Coordinate coordinate;
	private Direction direction;

	/**
	 * @param coordinate
	 * @param direction
	 */
	public Rover(Coordinate coordinate, Direction direction) {
		super();
		this.coordinate = coordinate;
		this.direction = direction;
	}

	/**
	 * 设置Rover的坐标
	 * 
	 * @param coordinate
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * 设置Rover的方向
	 * 
	 * @param direction
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * Rover左转
	 */
	public void turnLeft() {
		direction.turnLeft(this);
	}

	/**
	 * Rover右转
	 * 
	 */
	public void turnRight() {
		direction.turnRight(this);
	}

	/**
	 * Rover移动到下一个坐标
	 */
	public void move() {
		direction.move(coordinate);
	}

	@Override
	public String toString() {
		return "Rover [coordinate=(" + coordinate.getX() + ","
				+ coordinate.getY() + "), direction=" + direction.getName()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinate == null) ? 0 : coordinate.hashCode());
		result = prime * result
				+ ((direction == null) ? 0 : direction.getName().hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rover other = (Rover) obj;
		if (coordinate == null) {
			if (other.coordinate != null)
				return false;
		} else if (!coordinate.equals(other.coordinate))
			return false;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.getName().equals(other.direction.getName()))
			return false;
		return true;
	}

}
