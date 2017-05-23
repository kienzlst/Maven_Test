package kienzler.meldeauskunft.repository;

import java.util.*;
import kienzler.meldeauskunft.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {

	
	List<Resident> residents = new ArrayList<Resident>();
	
	public ResidentRepositoryStub(){
		Resident r1 = new Resident("Herbert", "Mueller", "Oxfordstreet","London",new Date(1960,2,3) );
		Resident r2 = new Resident("Helga", "Mueller", "Oxfordstreet","London",new Date(1965,10,18) );
		Resident r3 = new Resident("Petra", "Maier", "Schulstrasse","BErlin",new Date(1975,5,8) );
		Resident r4 = new Resident("Paul", "Steiner", "Feldweg","Hamburg",new Date(1990,4,1) );
	
		residents.add(r1);
		residents.add(r2);
		residents.add(r3);
		residents.add(r4);
	}
	
	
	
	
	
	
	public List<Resident> getResidents() {
		
		return residents;
	}
	
	
	
}
