package in.co.rays.project_3.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project_3.dto.StudentDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.StudentModelHibImpl;
import in.co.rays.project_3.model.StudentModelInt;
import in.co.rays.project_3.model.StudentModelJDBCImpl;
public class StudentModelTest {
	
	//public static StudentModelInt model = new StudentModelJDBCImpl();
			public static StudentModelInt model = new StudentModelHibImpl();
	
	public static void main(String[] args) throws ApplicationException, DuplicateRecordException, ParseException {
		//addTest();
		//deleteTest();
		//UpdateTest();
		//listTest();
		//searchTest();
		findByEmailIdTest();
	      //findByPkTest();	
	}
	public static void addTest() throws ApplicationException, DuplicateRecordException, ParseException {
		// TODO Auto-generated method stub
		StudentDTO dto = new StudentDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		dto.setId(1L);
		dto.setFirstName("hggcfx");
		dto.setLastName("sharma");
		dto.setDob(sdf.parse("15/01/1990"));
		dto.setMobileNo("94066553787");
		dto.setEmail("aaa@gmail.com");
		dto.setCollegeId(2L);
		dto.setCollegeName("davv");
		dto.setCreatedBy("Admin");
		dto.setModifiedBy("Admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		 model.add(dto);
		System.out.println("Test add succ");
		

	}
	public static void deleteTest() throws ApplicationException{
		StudentDTO dto= new StudentDTO();
		dto.setId(2L);
		model.delete(dto);
	}
	public static void UpdateTest() throws ParseException, ApplicationException, DuplicateRecordException{

        StudentDTO dto = new StudentDTO();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//    System.out.println("Test Update scc222"+dto.getCollegeName());
    dto.setId(3L);
    dto.setFirstName("ram");
    dto.setLastName("sharma");
    dto.setDob(sdf.parse("15/01/1990"));
    dto.setMobileNo("9165254357");
    dto.setEmail("ghht@hg.com");
    dto.setCollegeId(3L);
    dto.setCollegeName("LNCT");
    dto.setCreatedBy("Admin");
	dto.setModifiedBy("Admin");
	dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
    model.update(dto); 
		
	}
	public static void listTest() throws ApplicationException{
		// TODO Auto-generated method stub
				StudentDTO dto=new StudentDTO();
				
		       
		        List list = new ArrayList();
		        list = model.list(0,0);
		        if (list.size() < 0) {
		            System.out.println("Test list fail");
		        }
		        Iterator it = list.iterator();
		        while (it.hasNext()) {
		            dto = (StudentDTO) it.next();
		            System.out.println(dto.getId());
		            System.out.println(dto.getFirstName());
		            System.out.println(dto.getLastName());
		            System.out.println(dto.getDob());
		            System.out.println(dto.getMobileNo());
		            System.out.println(dto.getEmail());
		            System.out.println(dto.getCollegeId());
		            System.out.println(dto.getCreatedBy());
		            System.out.println(dto.getCreatedDatetime());
		            System.out.println(dto.getModifiedBy());
		            System.out.println(dto.getModifiedDatetime());}
		
	}
	public static void searchTest() throws ApplicationException {
		// TODO Auto-generated method stub
		StudentDTO dto=new StudentDTO();
		//dto.setId(1L);
		dto.setFirstName("ram");
		// dto.setLastName("agrawals");
		// dto.setMobileNO("989");
		// dto.setRoleId(101);
		// dto.setUnSuccessfullLogin(1);

		
		ArrayList<StudentDTO> a = (ArrayList<StudentDTO>) model.search(dto);
		for (StudentDTO uu : a) {

			System.out.println(uu.getId() + "\t" + uu.getFirstName() + "\t" + uu.getLastName() + "\t" + uu.getDob()
					+ "\t" + uu.getEmail() + "\t" + uu.getMobileNo() + "\t" + uu.getCollegeId() + "\t"
					+ uu.getCollegeName());}
	}
	

	public static void findByEmailIdTest() throws ApplicationException {
		// TODO Auto-generated method stub
		StudentDTO dto=model.findByEmailId("ghht@hg.com");
		System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t" + dto.getDob() + "\t"
				+ dto.getEmail() + "\t" + dto.getMobileNo() + "\t" + dto.getCollegeId() + "\t" + dto.getCollegeName());
		
	}

	public static void findByPkTest() throws ApplicationException {
		// TODO Auto-generated method stub
		StudentDTO dto=model.findByPK(3L);
		System.out.println(dto.getId() + "\t" + dto.getFirstName() + "\t" + dto.getLastName() + "\t" + dto.getDob() + "\t"
				+ dto.getEmail() + "\t" + dto.getMobileNo() + "\t" + dto.getCollegeId() + "\t" + dto.getCollegeName());
	}

}


