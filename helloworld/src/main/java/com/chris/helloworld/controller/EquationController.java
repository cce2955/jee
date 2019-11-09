package com.chris.helloworld.controller;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.helloworld.member.CurrentUsers;

import com.chris.helloworld.member.Equations;
import com.chris.helloworld.repo.EquationRepository;

@RestController
@ComponentScan(basePackages = "com.chris.helloworld")
@RequestMapping(path="/equations")
public class EquationController {
	public EquationRepository equationRepo;
	
	
	public EquationController(EquationRepository equationRepo) {
		super();
		this.equationRepo = equationRepo;
	}
	@GetMapping("/show")
	public List<Equations> index(){
        return equationRepo.findAll();
        		
	}
	
	@PostMapping("/create")
    public Equations create(@RequestBody Map<String, String> body){
        
		String product = null; //This stays null, it's update below in the putmappings
		String x = body.get("x");
		String y = body.get("y");
		String z = body.get("z");
        
        
        return equationRepo.save(new Equations(product, x, y, z));
 }
	
	@PutMapping("/update/{id}/{x}/{y}/{z}")
	 public Equations update(@PathVariable String id, @RequestBody Map<String, String> body){
       int eqId = Integer.parseInt(id);
       
       Equations eq = equationRepo.getOne(eqId);
       eq.setProduct(null);
       if(body.get("x").isBlank())
       {
    	   eq.setX(eq.getX());
       }
       else 
       {
    	   eq.setX(body.get("x"));
       }
       if(body.get("y").isBlank())
       {
    	   eq.setY(eq.getY());
       }
       else
       {
    	   eq.setY(body.get("y"));
       }
       if(body.get("z").isBlank())
       {
    	   eq.setZ(eq.getZ());
       }
       else
       {
    	   eq.setZ(body.get("z"));
       }
       
       
       return equationRepo.save(eq);
   }
	
	 @DeleteMapping("delete/{id}")
	    public boolean delete(@PathVariable String id){
	        int eqId = Integer.parseInt(id);
	        equationRepo.deleteById(eqId);
	        return true;
	    }
	 
	 @PutMapping("addXY/{id}")
	 public Equations getAddXY (@PathVariable String id,  @RequestBody Map<String, String> body)
	 {
		 int eqId = Integer.parseInt(id);
		 Equations equate = equationRepo.getOne(eqId);
		 int x = Integer.valueOf(equate.getX());
		 int y = Integer.valueOf(equate.getY());
		 int sum = x + y;
		 String strSum = String.valueOf(sum);
		 equate.setProduct(strSum);
		 
		 return equationRepo.save(equate);
	 }
	 
	 @PutMapping("addXYZ/{id}")
	 public Equations getAddXYZ (@PathVariable String id,  @RequestBody Map<String, String> body)
	 {
		 int eqId = Integer.parseInt(id);
		 Equations equate = equationRepo.getOne(eqId);
		 int x = Integer.valueOf(equate.getX());
		 int y = Integer.valueOf(equate.getY());
		 int z = Integer.valueOf(equate.getZ());
		 int sum = x + y + z;
		 String strSum = String.valueOf(sum);
		 equate.setProduct(strSum);
		 
		 return equationRepo.save(equate);
	 }
	 
	 @PutMapping("multiXY/{id}")
	 public Equations getMultiXY (@PathVariable String id,  @RequestBody Map<String, String> body)
	 {
		 int eqId = Integer.parseInt(id);
		 Equations equate = equationRepo.getOne(eqId);
		 int x = Integer.valueOf(equate.getX());
		 int y = Integer.valueOf(equate.getY());
		 int sum = x * y;
		 String strSum = String.valueOf(sum);
		 equate.setProduct(strSum);
		 
		 return equationRepo.save(equate);
	 }
	 
	 @PutMapping("addXYZ/{id}")
	 public Equations getMultiXYZ (@PathVariable String id,  @RequestBody Map<String, String> body)
	 {
		 int eqId = Integer.parseInt(id);
		 Equations equate = equationRepo.getOne(eqId);
		 int x = Integer.valueOf(equate.getX());
		 int y = Integer.valueOf(equate.getY());
		 int z = Integer.valueOf(equate.getZ());
		 int sum = x * y * z;
		 String strSum = String.valueOf(sum);
		 equate.setProduct(strSum);
		 
		 return equationRepo.save(equate);
	 }

}
