package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.StudentDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public class StudentModelJDBCImpl implements StudentModelInt {

	public long add(StudentDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(StudentDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void update(StudentDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(StudentDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(StudentDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public StudentDTO findByEmailId(String email) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
