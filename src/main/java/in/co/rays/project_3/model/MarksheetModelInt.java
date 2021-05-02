package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.MarksheetDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

public interface MarksheetModelInt {
	

	/**
	 * add of marksheet
	 * @param dto
	 * @throws ApplicationException
	 */
public long add(MarksheetDTO dto)throws ApplicationException,DuplicateRecordException;
/**
 * delete of marksheet
 * @param dto
 * @throws ApplicationException
 */
public void delete(MarksheetDTO dto)throws ApplicationException;
/**
 * update of marksheet
 * @param dto
 * @throws ApplicationException
 */
public void update(MarksheetDTO dto)throws ApplicationException,DuplicateRecordException;
/**
 * list of marksheet
 * @param dto
 * @throws ApplicationException
 */
public List list()throws ApplicationException;
/**
 * list of marksheet
 * @param dto
 * @throws ApplicationException
 */
public List list(int pageNo,int pageSize)throws ApplicationException;
/**
 * search of marksheet
 * @param dto
 * @throws ApplicationException
 */
public List search(MarksheetDTO dto)throws ApplicationException;
/**
 * search of marksheet
 * @param dto
 * @throws ApplicationException
 */
public List search(MarksheetDTO dto,int pageNo,int pageSize)throws ApplicationException;
/**
 * findby pk of marksheet
 * @param dto
 * @throws ApplicationException
 */
public MarksheetDTO fingByPK(long pk)throws ApplicationException;
/**
 * findby rollno of marksheet
 * @param dto
 * @throws ApplicationException
 */
public MarksheetDTO findByRollNo(String rollNo)throws ApplicationException;
/**
 * get meritlist of marksheet
 * @param dto
 * @throws ApplicationException
 */
public List getMeritList(int pageNo,int pageSize)throws ApplicationException;

}
