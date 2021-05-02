package in.co.rays.project_3.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;
import in.co.rays.project_3.model.UserModelHibImpl;
import in.co.rays.project_3.model.UserModelInt;
import in.co.rays.project_3.model.UserModelJDBCImpl;

public class UserModelTest {
	
	//public static UserModelInt model=new UserModelJDBCImpl();
	public static UserModelInt model=new UserModelHibImpl();
	
	public static void main(String[] args) throws ParseException, DuplicateRecordException, ApplicationException {
	   addTest();
	   //deleteTest();
		//updateTest();
		//findByLogin();
		//findByPKTest();
	}
	
	public static void addTest() throws ParseException, DuplicateRecordException, ApplicationException{
		UserDTO dto =new UserDTO();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		dto.setFirstName("janhvi");
		dto.setLastName("singh");
		dto.setDob(sdf.parse("06-08-2000"));
		dto.setConfirmPassword("12345");
		dto.setPassword("12345");
		dto.setLogin("janhvi@gmail.com");
		dto.setGender("female");
		dto.setUnSuccessfullLogin(1);
        dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");
		dto.setRoleId(1);
		dto.setMobileNo("8796542598");
		dto.setRegisteredIP("janhvi@gmail.com");
		dto.setLoginIP("janhvi@gmail.com");
		dto.setLastLogin(new Timestamp(new Date().getTime()));
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		long pk = model.add(dto);
		System.out.println(pk + "data successfully insert");
		
		
	}
	
	public static void deleteTest() throws DuplicateRecordException, ApplicationException{
		UserDTO dto=new UserDTO();
		dto.setId(4L);
		model.delete(dto);
		System.out.println("data deleted sucessfully.....");
		
	}
	
	public static void updateTest() throws DuplicateRecordException, ApplicationException, ParseException{
		
		UserDTO dto = new UserDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		dto.setId(2L);
		dto.setFirstName("tanya");
		
		dto.setLastName("bhaware");
		dto.setDob(sdf.parse("31-12-1996"));
		dto.setConfirmPassword("12345");
		dto.setPassword("12345");
		dto.setLogin("tanya@gmail.com");
		dto.setGender("females");
		dto.setUnSuccessfullLogin(2);
		
		dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");
		dto.setRoleId(1);
		dto.setMobileNo("8965987458");
		dto.setRegisteredIP("Tanya@gmail.com");
		dto.setLoginIP("tanya@gmail.com");
		dto.setLastLogin(new Timestamp(new Date().getTime()));
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(dto);
		
		
	}
	public static void findByLogin() throws ApplicationException{
		UserDTO dto = model.findByLogin("himshikha@gmail.com");
		System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t" + dto.getLogin()
				+ "\t" + dto.getPassword() + "\t" + dto.getDob() + "\t" + dto.getMobileNo() + "\t" + dto.getRoleId()
				+ "\t" + dto.getUnSuccessfullLogin() + "\t" + dto.getGender() + "\t" 
				 );
		
	}
	public static void findByPKTest() throws ApplicationException {
		// TODO Auto-generated method stub
		UserDTO dto = model.findByPk(1L);
		System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t" + dto.getLogin()
				+ "\t" + dto.getPassword() + "\t" + dto.getDob() + "\t" + dto.getMobileNo() + "\t" + dto.getRoleId()
				+ "\t" + dto.getUnSuccessfullLogin() + "\t" + dto.getGender() + "\t" + dto.getLastLogin() + "\t"
				+ "\t" + dto.getLastLogin() + "\t" + dto.getRegisteredIP());
	}
	public static void searchTest() throws ApplicationException {
		// TODO Auto-generated method stub
		UserDTO dto = new UserDTO();
      // dto.setId(1L);
		//dto.setFirstName("himshikha");
		dto.setLastName("kaware");
		// dto.setLogin("login");
		// dto.setPassword("123");
		// dto.setMobileNO("989");
	//	dto.setRoleId(1);
		// dto.setUnSuccessfullLogin(1);

		//dto.setGender("female");
        
		ArrayList<UserDTO> a = (ArrayList<UserDTO>) model.search(dto,0,0);
		
		for (UserDTO udto1 : a) {
			System.out.println(udto1.getId() + "\t" + udto1.getFirstName() + "\t" + udto1.getLastName() + "\t"
					+ udto1.getLogin() + "\t" + udto1.getPassword() + "\t" + udto1.getDob() + "\t"
					+ udto1.getMobileNo() + "\t" + udto1.getRoleId() );}
	}
	public static void listTest() throws ApplicationException {
		// TODO Auto-generated method stub
		UserDTO dto = new UserDTO();
		List list = new ArrayList();
		list = model.list(1, 10);
		if (list.size() < 0) {
			System.out.println("list fail");
		}
		Iterator it = list.iterator();
		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getRoleId());
			System.out.println(dto.getUnSuccessfullLogin());
			System.out.println(dto.getGender());
			System.out.println(dto.getLastLogin());
			
			System.out.println(dto.getMobileNo());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getModifiedDatetime());
		}
	}
	

}
