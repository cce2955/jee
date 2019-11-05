package org.o7planning.basicbeans;
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
				System.out.println(message);
				//-------------
				int mathReturn = math.add();
				System.out.println(mathReturn);
				//-------------
				service.setName("Multiplying");
				System.out.println(message);
				//------------------------
				mathReturn = math.multiply();
				System.out.println(mathReturn);
				//-----------------
				service.setName("Subtracting");
				System.out.println(message);
				//----------------------
				mathReturn = math.subtract();
				System.out.println(mathReturn);
				//-----------------
				service.setName("Dividing");
				System.out.println(message);
				//-----------------
				mathReturn = math.divide();
				System.out.println(mathReturn);
						
			}
		

	}


