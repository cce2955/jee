package org.o7planning.basicbeans;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.stereotype.Service;

@Service("mathService")
public class calculationBeanService {
	private int x;
	private int y;
	private HashSet<Integer> mathSet = new HashSet<Integer>();
	
	
	
	public HashSet<Integer> getMathSet() {
		return mathSet;
	}

	public void setMathSet(HashSet<Integer> mathSet) {
		this.mathSet = mathSet;
	}

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
		int z = x*y;
		mathSet.add(z);
		return z;
		
	}
	
	public int add()
	{
		int z = x + y;
		mathSet.add(z);
		return z;
		
	}
	public int divide()
	{
		int z = x/y;
		mathSet.add(z);
		return z;
		
	}
	public int subtract()
	{
		int z = x - y;
		mathSet.add(z);
		return z;
		
	}
}
