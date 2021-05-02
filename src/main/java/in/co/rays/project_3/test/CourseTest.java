package in.co.rays.project_3.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project_3.dto.CourseDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CourseModelHibImpl;
import in.co.rays.project_3.model.CourseModelInt;
import in.co.rays.project_3.model.CourseModelJDBCImpl;

public class CourseTest {
	
	public static CourseModelInt model=new CourseModelHibImpl();
	//public static CourseModelInt model=new CourseModelJDBCImpl();
	public static void main(String[] args) throws Exception {
		//addTest();
		searchTest();
		//findByPkTest();
	}
	public static void findByPkTest() throws ApplicationException {
		// TODO Auto-generated method stub
		CourseDTO dto=model.findByPK(2L);
		System.out.println(dto.getId() + "\t" + dto.getCourseName() + "\t" + dto.getDescription() + "\t"
				+ dto.getDuration());
	}
	
	public static void searchTest() throws ApplicationException {
		// TODO Auto-generated method stub
		CourseDTO cbean1 = new CourseDTO();
		cbean1.setId(2L);
		//cbean1.setCourseName("Mtech");
		System.out.println("hello");

		
		List<CourseDTO> a = (List<CourseDTO>) model.search(cbean1,0,0);
		for (CourseDTO dto : a) {
			System.out.println(dto.getId() + "\t" + dto.getCourseName() + "\t" + dto.getDescription() + "\t"
					+ dto.getDuration());
		}
	}
	
	public static void addTest() throws Exception {
		// TODO Auto-generated method stub
		CourseDTO dto=new CourseDTO();

		dto.setCourseName("BE");
		dto.setDescription("gegree");
		dto.setDuration("4year");
		dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(dto);
		
	}

}
