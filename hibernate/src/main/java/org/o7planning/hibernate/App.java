package org.o7planning.hibernate;
import java.util.List; 
import java.util.Date;
import java.util.Iterator; 
import javax.transaction.*; 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App 
{
	 private static SessionFactory factory;
	 
	   public static void main(String[] args) {
	      
	      try {
	         factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      
	      App useApp = new App();
	      
	      Integer meat1 = useApp.addFood("Beef", 1, 3);
	      Integer meat2 = useApp.addFood("Chicken", 2, 5);
	      Integer meat3 = useApp.addFood("Steak", 2, 9);
	    		  
	    	useApp.listFood();	  
	      	      
	      
	   }
	   
	   /* Method to CREATE an employee in the database */
	   public Integer addFood(String fname, int fweight, int fprice){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer meatID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         
	         food meat = new food(fname, fweight, fprice);
	         meatID = (Integer) session.save(meat);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return meatID;
	   }
	   
	   /* Method to  READ all the employees */
	   public void listFood( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List food = session.createQuery("FROM food").list(); 
	         for (Iterator iterator = food.iterator(); iterator.hasNext();){
	            food meat = (food) iterator.next(); 
	            System.out.print("Name: " + meat.getName()); 
	            System.out.print("  Price: " + meat.getPrice()); 
	            System.out.println("  Weight: " + meat.getWeight()); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   
	   public void updateFood( ){
	   // Used to update, not doing tha tnow
	   }
	   
	   /* Method to DELETE */
	   public void deleteFood(){
	   }
}
