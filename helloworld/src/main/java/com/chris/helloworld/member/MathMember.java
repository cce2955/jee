package com.chris.helloworld.member;

public class MathMember {
	public int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public MathMember(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String add()
	{
		return y + x + "";
	}
	
}
