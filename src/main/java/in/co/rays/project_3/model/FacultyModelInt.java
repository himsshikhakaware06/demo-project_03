package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.FacultyDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface FacultyModelInt {
	

	/**
	 * add if faculty
	 * @author ayushi
	 *
	 */
public long add(FacultyDTO dto)throws ApplicationException,DuplicateRecordException;
/**
 *delete of faculty
 * @author ayushi
 *
 */
public void delete(FacultyDTO dto)throws ApplicationException;
/**
 * update of fayclty
 * @author ayushi
 *
 */
public void update(FacultyDTO dto)throws ApplicationException,DatabaseException, DuplicateRecordException;
/**
 * list of faculty
 * @author ayushi
 *
 */
public List list()throws ApplicationException;
/**
 * list of faculty
 * @author ayushi
 *
 */
public List list(int pageNo,int pageSize)throws ApplicationException;
/**
 * search of faculty
 * @author ayushi
 *
 */
public List search(FacultyDTO dto)throws ApplicationException;
/**
 * search of faculty
 * @author ayushi
 *
 */
public List search(FacultyDTO dto,int pageNo,int pageSize)throws ApplicationException;
/**
 * findby pk of faculty
 * @author ayushi
 *
 */
public FacultyDTO findByPK(long pk)throws ApplicationException;
/**
 * find by emailid of faculty
 * @author ayushi
 *
 */
public FacultyDTO  findByEmailId(String emailId)throws ApplicationException;

}
