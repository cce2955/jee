package org.o7planning.spring.service;

import java.util.List;

import org.o7planning.spring.dao.CountryDAO;
import org.o7planning.spring.model.Country;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CountryServiceImplementation implements CountryService {
		
		private CountryDAO countryDAO;

		public void setCountryDAO(CountryDAO countryDAO) {
			this.countryDAO = countryDAO;
		}
		
		@Override
		@Transactional
		public void addCountry(Country p) {
			this.countryDAO.addCountry(p);
		}

		@Override
		@Transactional
		public void updateCountry(Country p) {
			this.countryDAO.updateCountry(p);
		}

		@Override
		@Transactional
		public List<Country> listCountries() {
			
			return this.countryDAO.listCountries();
		}

		@Override
		@Transactional
		public Country getCountryById(int id) {
			return this.countryDAO.getCountryById(id);
		}

		@Override
		@Transactional
		public void removeCountry(int id) {
			this.countryDAO.removeCountry(id);
		}

	}
