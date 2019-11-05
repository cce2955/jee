package org.o7planning.basicbeans;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		// loading the definitions from the given XML file
				@SuppressWarnings("resource")
				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 
				HelloWorldService service = (HelloWorldService) context.getBean("helloWorldService");
				calculationBeanService math = (calculationBeanService) context.getBean("mathService");
				String message = service.sayHello();
				System.out.println(message);
		 
				//set a new name
				service.setName("Spring");
				message = service.sayHello();
				System.out.println(message);
				//-----------
				service.setName("Adding 5 + 6");
				message = service.showMath();
				System.out.println(message);
				
				//-------------
				int mathReturn = math.add();
				System.out.println(mathReturn);
				//-------------
				service.setName("Multiplying");
				message = service.showMath();
				System.out.println(message);
				//------------------------
				mathReturn = math.multiply();
				System.out.println(mathReturn);
				//-----------------
				service.setName("Subtracting");
				message = service.showMath();
				System.out.println(message);
				//----------------------
				mathReturn = math.subtract();
				
				System.out.println(mathReturn);
				//-----------------
				service.setName("Dividing");
				message = service.showMath();
				System.out.println(message);
				//-----------------
				mathReturn = math.divide();
				System.out.println(mathReturn);
						
				System.out.println("Set the first value, and we'll do the thing: ");
				Scanner input = new Scanner(System.in);
				int userInput = input.nextInt();
				math.setX(userInput);
				System.out.println("And the second");
				userInput = input.nextInt();
				math.setY(userInput);
				System.out.println("Added together: " + math.add() + " Subtracted: " + math.subtract() + " multiplied: " + math.multiply() + " divide: " + math.divide());
				System.out.println(math.getMathSet());
				
				
			}
		

	}


