package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.CollegeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

/**
 * data access object of college
 * @author himshikha
 *
 */
public interface CollegeModelInt {
	
	/**
	 * add of college
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(CollegeDTO dto)throws ApplicationException,DuplicateRecordException;
	/**
	 * delete of college
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(CollegeDTO dto)throws ApplicationException;
	/**
	 * update of college
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public void update(CollegeDTO dto)throws ApplicationException,DuplicateRecordException;
	/**
	 * list of college
	 * @return
	 * @throws ApplicationException
	 */
	public List list()throws ApplicationException;
	/**list of college
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ApplicationException
	 */
	public List list(int pageNo,int pageSize)throws ApplicationException;
	/**
	 * search of college
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 */
	public List search(CollegeDTO dto)throws ApplicationException;
	/**
	 * search of college
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ApplicationException
	 */
	public List search(CollegeDTO dto,int pageNo,int pageSize)throws ApplicationException;
	/**
	 * findby pk of college
	 * @param pk
	 * @return
	 * @throws ApplicationException
	 */
	public CollegeDTO findByPK(long pk)throws ApplicationException;
	/**
	 * @param name
	 * @return
	 * @throws ApplicationException
	 */
	public CollegeDTO fingByName(String name)throws ApplicationException;

}
