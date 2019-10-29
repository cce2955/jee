package main.webapp;

import java.util.List;
import org.hibernate.*;
import org.hibernate.Session;
 


public class Hibernateapplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hibernateapplication application = new Hibernateapplication();
		
		int meat1 = application.meatIndex("beef", 1, 1);
		int meat2 = application.meatIndex("chicken", 10, 6);
		int meat3 = application.meatIndex("bacon", 2, 5);
		
		
	}
	
	public int meatIndex (String name, int weight, int price)
	{
		Meat meat = new Meat();
		meat.setName(name);
		meat.setPrice(price);
		meat.setWeight(weight);
		
		Session session = Utility.getSessionFactory().openSession();
		session.beginTransaction();
		
		int id = (Integer) session.save(meat);
		session.getTransaction().commit();
		session.close();
		return id;
		
	}
}
