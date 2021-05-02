package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.SubjectDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface SubjectModelInt {
	

	/**
	 * add of of subjectmodel
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * 
	 */
public long add(SubjectDTO dto)throws ApplicationException,DuplicateRecordException;
/**
 * delete of subjectmodel
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public void delete(SubjectDTO dto)throws ApplicationException;
/**
 * update  of subjectmodel
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public void update(SubjectDTO dto)throws ApplicationException,DuplicateRecordException;
/**
 * list  of subjectmodel
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public List list()throws ApplicationException;
/**
 * list  of subjectmodel
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public List list(int pageNo,int pageSize)throws ApplicationException;
/** search  of subjectmodel
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public List search(SubjectDTO dto)throws ApplicationException;
/** search of subjectmodel
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public List search(SubjectDTO dto,int pageNo,int pageSize)throws ApplicationException;
/** findByPK  of subjectmodel
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public SubjectDTO findByPK(long pk)throws ApplicationException;
/** findByName of subjectmodel
 * @param dto
 * @return
 * @throws ApplicationException
 * 
 */
public SubjectDTO findByName(String name)throws ApplicationException;
}
