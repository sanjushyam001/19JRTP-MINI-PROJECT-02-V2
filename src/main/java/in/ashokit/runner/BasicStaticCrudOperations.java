package in.ashokit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.City;
import in.ashokit.entity.Country;
import in.ashokit.entity.State;
import in.ashokit.repository.CityRepository;
import in.ashokit.repository.CountryRepository;
import in.ashokit.repository.StateRepository;

//@Component
public class BasicStaticCrudOperations implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Override
	public void run(String... args) throws Exception {
		//#1. Save Country
		
		countryRepo.save(new Country("IND", "India"));
		countryRepo.save(new Country("AUS", "Australia"));
		
		//#2. Save State
		
		stateRepo.save(new State("Uttar Pradesh", 1));
		stateRepo.save(new State("Bihar", 1));
		stateRepo.save(new State("Queensland", 2));
		stateRepo.save(new State("South Australia", 2));
		
		//#4 Save City
		
		//UP
		cityRepo.save(new City("Noida", 3));
		cityRepo.save(new City("Moradabad", 3));
		
		//Bihar 
		cityRepo.save(new City("Patna", 4));
		cityRepo.save(new City("Baliya", 4));
		
		//Queensland
		cityRepo.save(new City("Brisbane", 5));
		cityRepo.save(new City("Mackay", 5));
		
		//South Australia
		cityRepo.save(new City("Coober Pedy", 6));
		cityRepo.save(new City("Whyalla", 6));
		
		
		
		
		
		

	}

	
}
