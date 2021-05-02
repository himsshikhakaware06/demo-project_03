package in.co.rays.project_3.model;

import java.util.Date;
import java.util.List;

import in.co.rays.project_3.dto.TimeTableDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public class TimeTableModelJDBCImpl implements TimeTableModelInt {

	public long add(TimeTableDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void update(TimeTableDTO dto) throws ApplicationException, DuplicateRecordException, DatabaseException {
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

	public List search(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(TimeTableDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkByCourseName(long courseId, Date examDate)
			throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkBySubjectName(long courseId, long subjectId, Date examDate)
			throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkBysemester(long courseId, long subjectId, String semester, Date examDate)
			throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

}
