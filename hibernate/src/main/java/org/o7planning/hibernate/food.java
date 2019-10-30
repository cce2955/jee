package org.o7planning.hibernate;

public class food {
	
	private int id;
	private String name;
	private int weight;
	private int price;
	
	public food() {};
	public food(String fname, int fweight, int fprice)
	{
		this.name = fname;
		this.weight = fweight;
		this.price = fprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
