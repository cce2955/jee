package org.o7planning.spring.service;

import java.util.List;

import org.o7planning.spring.model.Country;

public interface CountryService {
	public void addCountry(Country p);
	public void updateCountry(Country p);
	public List<Country> listCountries();
	public Country getCountryById(int id);
	public void removeCountry(int id);
	

}
