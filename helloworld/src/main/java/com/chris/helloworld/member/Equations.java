package com.chris.helloworld.member;

import java.util.stream.IntStream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Qualifier;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Just out of curiousity I'm going to use hibernate to generate a table of values, then utilizing IDs I will perform various functions with them
@Entity
public class Equations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int equations_id;
	
		private String x;
	private String y;
	private String z;
	private String product;
	
	public Equations() {};
	
	public Equations(String Product, String x, String y, String z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	public int getEquations_id() {
		return equations_id;
	}

	public void setEquations_id(int equations_id) {
		this.equations_id = equations_id;
	}

}
