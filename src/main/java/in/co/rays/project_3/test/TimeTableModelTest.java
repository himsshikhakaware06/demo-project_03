package in.co.rays.project_3.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project_3.dto.TimeTableDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.TimeTableModelHibImpl;
import in.co.rays.project_3.model.TimeTableModelInt;



public class TimeTableModelTest {
	
	public static TimeTableModelInt model=new TimeTableModelHibImpl();
	//public static TimetableModelInt model=new TimetableModelJDBCImpl();
	public static void main(String[] args) throws Exception {
		addTest();
		//deleteTest();
		//updateTest();
		//findByPkTest();
		//findByNameTest();
	//searchTest();
		//listTest();
		//checkByCourseName();
		//checkBySubjectName();
		//checkBySemester();
	}
	public static void checkBySemester() throws ApplicationException, DuplicateRecordException, ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		TimeTableDTO dto=model.checkBysemester(102, 6,"third", sdf.parse("01/02/2012"));
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getSubId());
		System.out.print("\t" + dto.getSubName());
		System.out.print("\t" + dto.getCourseId());
		System.out.print("\t" + dto.getCourseName());
		System.out.print("\t" + dto.getSemester());
		System.out.print("\t" + dto.getExamDate());
		System.out.print("\t" + dto.getExamTime());
		System.out.print("\t" + dto.getDescription());
	}
	public static void checkBySubjectName() throws ApplicationException, DuplicateRecordException, ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		TimeTableDTO dto=model.checkBySubjectName(102, 1, sdf.parse("01/02/2012"));
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getSubId());
		System.out.print("\t" + dto.getSubName());
		System.out.print("\t" + dto.getCourseId());
		System.out.print("\t" + dto.getCourseName());
		System.out.print("\t" + dto.getSemester());
		System.out.print("\t" + dto.getExamDate());
		System.out.print("\t" + dto.getExamTime());
		System.out.print("\t" + dto.getDescription());
	}
	public static void checkByCourseName() throws ApplicationException, DuplicateRecordException, ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		TimeTableDTO dto=model.checkByCourseName(102,sdf.parse("01/02/2012") );
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getSubId());
		System.out.print("\t" + dto.getSubName());
		System.out.print("\t" + dto.getCourseId());
		System.out.print("\t" + dto.getCourseName());
		System.out.print("\t" + dto.getSemester());
		System.out.print("\t" + dto.getExamDate());
		System.out.print("\t" + dto.getExamTime());
		System.out.print("\t" + dto.getDescription());
	}
	public static void listTest() throws ApplicationException {
		// TODO Auto-generated method stub
		TimeTableDTO dto=new TimeTableDTO();
		List list=model.list(0, 0);
		Iterator it=list.iterator();
		while(it.hasNext()){
			 dto=(TimeTableDTO)it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getSubId());
			System.out.print("\t" + dto.getSubName());
			System.out.print("\t" + dto.getCourseId());
			System.out.print("\t" + dto.getCourseName());
			System.out.print("\t" + dto.getSemester());
			System.out.print("\t" + dto.getExamDate());
			System.out.print("\t" + dto.getExamTime());
			System.out.print("\t" + dto.getDescription());
		}
	}
	public static void searchTest() throws ApplicationException {
		// TODO Auto-generated method stub
		TimeTableDTO dto1=new TimeTableDTO();
		dto1.setId(1L);
		//dto1.setCourseName("bsc");
		List<TimeTableDTO> a=(List<TimeTableDTO>) model.search(dto1, 0, 0);
		for(TimeTableDTO dto: a){
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getSubId());
			System.out.print("\t" + dto.getSubName());
			System.out.print("\t" + dto.getCourseId());
			System.out.print("\t" + dto.getCourseName());
			System.out.print("\t" + dto.getSemester());
			System.out.print("\t" + dto.getExamDate());
			System.out.print("\t" + dto.getExamTime());
			System.out.print("\t" + dto.getDescription());
			
		}
	}
	public static void findByNameTest() {
		// TODO Auto-generated method stub
		TimeTableDTO dto=new TimeTableDTO();
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getSubId());
		System.out.print("\t" + dto.getSubName());
		System.out.print("\t" + dto.getCourseId());
		System.out.print("\t" + dto.getCourseName());
		System.out.print("\t" + dto.getSemester());
		System.out.print("\t" + dto.getExamDate());
		System.out.print("\t" + dto.getExamTime());
		System.out.print("\t" + dto.getDescription());
	}
	public static void findByPkTest() throws ApplicationException {
		// TODO Auto-generated method stub
		TimeTableDTO dto=model.findByPK(1L);
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getSubId());
		System.out.print("\t" + dto.getSubName());
		System.out.print("\t" + dto.getCourseId());
		System.out.print("\t" + dto.getCourseName());
		System.out.print("\t" + dto.getSemester());
		System.out.print("\t" + dto.getExamDate());
		System.out.print("\t" + dto.getExamTime());
		System.out.print("\t" + dto.getDescription());
	}
	public static void updateTest() throws ApplicationException, DuplicateRecordException, DatabaseException {
		// TODO Auto-generated method stub
		TimeTableDTO dto=new TimeTableDTO();
		dto.setId(1L);
		dto.setSubId(1);
		dto.setSubName("physics");
		dto.setCourseId(102);
		dto.setCourseName("bee");
		dto.setSemester("fourth");
		
		dto.setExamTime("4hr");
		dto.setDescription("hello...");
		model.update(dto);
	}
	public static void deleteTest() throws ApplicationException {
		// TODO Auto-generated method stub
		TimeTableDTO dto=new TimeTableDTO();
		dto.setId(2L);
		model.delete(dto);
	}
	public static void addTest() throws ParseException, ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		TimeTableDTO dto=new TimeTableDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		dto.setSubId(1);
		dto.setSubName("physics");
		dto.setCourseId(102);
		dto.setCourseName("BE");
		dto.setSemester("fourth");
		dto.setExamDate(sdf.parse("01/02/2012"));
		dto.setExamTime("3hr");
		dto.setDescription("hello...");
		model.add(dto);
	}
	

}
