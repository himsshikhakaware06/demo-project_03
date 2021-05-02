package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.TimeTableDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface TimeTableModelInt  {
	
	/**
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * 
	 */
public long add(TimeTableDTO dto)throws ApplicationException,DuplicateRecordException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public void delete(TimeTableDTO dto)throws ApplicationException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public void update(TimeTableDTO dto)throws ApplicationException,DuplicateRecordException,DatabaseException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public List list()throws ApplicationException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public List list(int pageNo,int pageSize)throws ApplicationException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public List search(TimeTableDTO dto)throws ApplicationException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public List search(TimeTableDTO dto,int pageNo,int pageSize)throws ApplicationException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public TimeTableDTO findByPK(long pk)throws ApplicationException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public TimeTableDTO checkByCourseName(long courseId,java.util.Date examDate)throws ApplicationException,DuplicateRecordException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public TimeTableDTO checkBySubjectName(long courseId,long subjectId,java.util.Date examDate)throws ApplicationException,DuplicateRecordException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public TimeTableDTO checkBysemester(long courseId,long subjectId,String semester,java.util.Date examDate)throws ApplicationException,DuplicateRecordException;
}
