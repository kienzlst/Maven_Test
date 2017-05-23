package kienzler;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import kienzler.meldeauskunft.domain.Resident;
import kienzler.meldeauskunft.service.BaseResidentService;
import kienzler.meldeauskunft.service.ResidentService;
import kienzler.meldeauskunft.service.ResidentServiceException;
import kienzler.meldeauskunft.repository.*;


public class ResidentServiceTest {
	
	BaseResidentService service;
	ResidentRepositoryStub rrs;

	public ResidentServiceTest(){
		this.service = new BaseResidentService();
		this.rrs = new ResidentRepositoryStub();
		service.setResidentRepository(rrs);
	}
	
	@Test
	public void testgetFilteredResidentList1() {
		Resident residentFilter = new Resident("","S*","","",null);
		List<Resident> filteredResidentList = service.getFilteredResidentsList(residentFilter);
		assertEquals(filteredResidentList.size(), 1);
		assertEquals(filteredResidentList.get(0),rrs.getResidents().get(3) );
		
		 
	}
	
	@Test
	public void testgetFilteredResidentList2() {
		Resident residentFilter = new Resident("","","","",new Date(1975,5,8));
		List<Resident> filteredResidentList = service.getFilteredResidentsList(residentFilter);
		assertEquals(filteredResidentList.size(), 1);
		assertEquals(filteredResidentList.get(0),rrs.getResidents().get(2) );
		 
	}
	
	@Test
	public void testgetFilteredResidentList3() {
		Resident residentFilter = rrs.getResidents().get(1); 
		List<Resident> filteredResidentList = service.getFilteredResidentsList(residentFilter);
		assertEquals(filteredResidentList.size(), 1);
		assertEquals(filteredResidentList.get(0),rrs.getResidents().get(1) );
		 
	}
	
	@Test
	public void testgetUniqueResident1(){
		Resident residentFilter = rrs.getResidents().get(1); 
		Resident uniqueResident = null;
		try{
			uniqueResident = service.getUniqueResident(residentFilter);
		}catch(ResidentServiceException e){
			fail("fehler");
		}
		assertEquals(uniqueResident,rrs.getResidents().get(1) );
	
	}
	
	@Test(expected = ResidentServiceException.class)
	public void testgetUniqueResident2() throws ResidentServiceException{
		Resident residentFilter = new Resident("","M*","","",null);
		Resident uniqueResident = service.getUniqueResident(residentFilter);
	
		fail("ResidentServiceException not thrown");
	
	}
	
	@Test(expected = ResidentServiceException.class)
	public void testgetUniqueResident3() throws ResidentServiceException{
		Resident residentFilter = new Resident("","Y*","","",null);
		Resident uniqueResident = service.getUniqueResident(residentFilter);
	
		fail("ResidentServiceException not thrown");
	}
	

}
