package in.co.rays.project_3.test;

import in.co.rays.project_3.dto.RoleDto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.management.relation.Role;
import javax.swing.event.RowSorterListener;

import in.co.rays.project_3.dto.RoleDto;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.RoleModelHibImpl;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.model.RoleModelJDBCImpl;

public class RoleModelTest {
	
	//public static RoleModelInt model=new RoleModelHibImpl();
	public static RoleModelInt model=new RoleModelJDBCImpl();
	
	public static void main(String[] args) throws Exception {
		//addTest();
		//DeleteTest();
		//updateTest();
		//listTest();
		//searchTest();
		//findByPkTest();
		//findByNameTest();
	}
	
	public static void addTest() throws Exception{
		// TODO Auto-generated method stub
		RoleDto dto=new RoleDto();
		dto.setName("student");
		dto.setDescription("admin");
		dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		System.out.println("add role");
		model.add(dto);
	}
	
	public static void DeleteTest() throws ApplicationException{
    RoleDto dto=new RoleDto();
     dto.setId(3L);
     model.delete(dto);
		
	}
	public static void updateTest() throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		RoleDto dto=new RoleDto();
		dto.setId(2L);
		dto.setName("student");
		dto.setDescription("student");
		dto.setCreatedBy("admin");
		dto.setModifiedBy("admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(dto);
	}
	public static void listTest() throws ApplicationException {
		// TODO Auto-generated method stub
		List list=model.list(0, 0);
		Iterator it=list.iterator();
		while(it.hasNext()){
			RoleDto dto=(RoleDto) it.next();
			System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getDescription());
		}
		
	}
	public static void searchTest() throws ApplicationException{
		RoleDto dto1=new RoleDto();
		dto1.setId(1L);
		dto1.setName("admin");
		List<RoleDto> a=(List<RoleDto>) model.search(dto1, 0, 0);
		for(RoleDto dto: a){
			System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getDescription());
		}
	}
	
	public static void findByPkTest() throws ApplicationException {
		// TODO Auto-generated method stub
		RoleDto dto=model.findByPK(1L);
		System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getDescription());
	}
	public static void findByNameTest() throws ApplicationException {
		// TODO Auto-generated method stub
		RoleDto dto=model.findByName("admin");
		System.out.println(dto.getId()+"\t"+dto.getName()+"\t"+dto.getDescription());
	}
	
}
