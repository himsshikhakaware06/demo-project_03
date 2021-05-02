package in.co.rays.project_3.test;

import java.sql.Timestamp;
import java.util.Date;

import in.co.rays.project_3.dto.CollegeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CollegeModelHibImpl;
import in.co.rays.project_3.model.CollegeModelInt;
import in.co.rays.project_3.model.CollegeModelJDBCImpl;

public class CollegeModelTest {

	public static CollegeModelInt model=new CollegeModelHibImpl();
	//public static CollegeModelInt model=new CollegeModelJDBCImpl();
	
	
	public static void main(String[] args) throws Exception {
		//addTest();
		//DeleteTest();
		UpdateTest();
		//findByPKTest();
		//findByNameTest();
	}
	public static void addTest() throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		 CollegeDTO dto = new CollegeDTO();
	     dto.setId(1L);
	     dto.setName("IIST");
	     dto.setAddress("Pithampur road");
	     dto.setState("mp");
	     dto.setCity("indore");
	     dto.setPhoneNo("8754698545");
	     dto.setCreatedBy("Admin");
	     dto.setModifiedBy("Admin");
	     dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	     dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	     long pk = model.add(dto); 
	}
	public static void DeleteTest() throws ApplicationException{
		CollegeDTO dto=new CollegeDTO();
        dto.setId(2L);
        model.delete(dto);
        System.out.println("Deleted sucessfully");
        
	}
	public static void UpdateTest() throws ApplicationException, DuplicateRecordException{
		 CollegeDTO dto = new CollegeDTO();
	     dto.setId(3L);
	     dto.setName("IPS");
	     dto.setAddress("rajendra nager");
	     dto.setState("mp");
	     dto.setCity("indore");
	     dto.setPhoneNo("073124244");
	     dto.setCreatedBy("Admin");
	     dto.setModifiedBy("Admin");
	     dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	     dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	     model.update(dto);
		
	}
	public static void findByPKTest() throws ApplicationException {
		// TODO Auto-generated method stub
		CollegeDTO dto=model.findByPK(1L);
		System.out.println(dto.getId());
	    System.out.println(dto.getName());
	    System.out.println(dto.getAddress());
	    System.out.println(dto.getState());
	    System.out.println(dto.getCity());
	    System.out.println(dto.getPhoneNo());
	    System.out.println(dto.getCreatedBy());
	    System.out.println(dto.getCreatedDatetime());
	    System.out.println(dto.getModifiedBy());
	    System.out.println(dto.getModifiedDatetime()); 
	}
	public static void findByNameTest() throws ApplicationException {
		// TODO Auto-generated method stub
		CollegeDTO dto=model.fingByName("Truba");
		System.out.println(dto.getId());
	    System.out.println(dto.getName());
	    System.out.println(dto.getAddress());
	    System.out.println(dto.getState());
	    System.out.println(dto.getCity());
	    System.out.println(dto.getPhoneNo());
	    System.out.println(dto.getCreatedBy());
	    System.out.println(dto.getCreatedDatetime());
	    System.out.println(dto.getModifiedBy());
	    System.out.println(dto.getModifiedDatetime()); 
	}
	
	
}
