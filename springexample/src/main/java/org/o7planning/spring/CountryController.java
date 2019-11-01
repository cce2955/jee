package org.o7planning.spring;

import org.o7planning.spring.model.Country;
import org.o7planning.spring.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountryController {
	private CountryService countryService;
	
	@Autowired(required=true)
	@Qualifier(value="countryService")
	public void setcountryService(CountryService cs){
		this.countryService = cs;
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public String listcountrys(Model model) {
		model.addAttribute("country", new Country());
		model.addAttribute("listcountries", this.countryService.listCountries());
		return "country";
	}
	
	//For add and update country both
	@RequestMapping(value= "/country/add", method = RequestMethod.POST)
	public String addcountry(@ModelAttribute("country") Country c){
		
		if(c.getId() == 0){
			//new country, add it
			this.countryService.addCountry(c);
		}else{
			//existing country, call update
			this.countryService.updateCountry(c);
		}
		
		return "redirect:/countries";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removecountry(@PathVariable("id") int id){
		
        this.countryService.removeCountry(id);
        return "redirect:/countries";
    }
 
    @RequestMapping("/edit/{id}")
    public String editcountry(@PathVariable("id") int id, Model model){
        model.addAttribute("country", this.countryService.getCountryById(id));
        model.addAttribute("listcountries", this.countryService.listCountries());
        return "country";
    }
	
}

