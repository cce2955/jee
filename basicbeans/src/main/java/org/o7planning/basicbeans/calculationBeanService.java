package org.o7planning.basicbeans;
import org.springframework.stereotype.Service;

@Service("mathService")
public class calculationBeanService {
	private int x;
	private int y;
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	//----------------------
	//Defined beans
	public int multiply()
	{
		return x * y;
	}
	
	public int add()
	{
		return x + y;
		
	}
	public int divide()
	{
		return x/y;
		
	}
	public int subtract()
	{
		return x - y;
		
	}
}
