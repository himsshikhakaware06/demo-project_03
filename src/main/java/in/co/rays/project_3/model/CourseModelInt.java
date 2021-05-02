package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.CourseDTO;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.ApplicationException;


public interface CourseModelInt {
	
	/**
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(CourseDTO dto)throws ApplicationException,DuplicateRecordException;
	/**
	 * add of course
	 * @param dto
	 * @throws ApplicationException
	 */
	public void delete(CourseDTO dto)throws ApplicationException;
	/**
	 * delete of course
	 * @param dto
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public void update(CourseDTO dto)throws ApplicationException,DuplicateRecordException;
	/**update of course
	 * @return
	 * @throws ApplicationException
	 */
	public List list()throws ApplicationException;
	/**
	 * list of course
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ApplicationException
	 */
	public List list(int pageNo,int pageSize)throws ApplicationException;
	/**
	 * list of course
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 */
	public List search(CourseDTO dto)throws ApplicationException;
	/**
	 * search of course
	 * @param dto
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws ApplicationException
	 */
	public List search(CourseDTO dto,int pageNo,int pageSize)throws ApplicationException;
	/**
	 * find by pk of course
	 * @param pk
	 * @return
	 * @throws ApplicationException
	 */
	public CourseDTO findByPK(long pk)throws ApplicationException;
	/**
	 * find by name of course
	 * @param name
	 * @return
	 * @throws ApplicationException
	 */
	public CourseDTO findByName(String name)throws ApplicationException;
	

}
