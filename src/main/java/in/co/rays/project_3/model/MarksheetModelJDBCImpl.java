package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.MarksheetDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public class MarksheetModelJDBCImpl implements MarksheetModelInt {

	public long add(MarksheetDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(MarksheetDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void update(MarksheetDTO dto) throws ApplicationException, DuplicateRecordException {
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

	public List search(MarksheetDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(MarksheetDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public MarksheetDTO fingByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public MarksheetDTO findByRollNo(String rollNo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List getMeritList(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
