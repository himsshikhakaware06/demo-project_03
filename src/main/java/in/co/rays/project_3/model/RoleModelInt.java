package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.RoleDto;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;

/**
 * data access object of rolemodel int
 * @author himshikha
 *
 */
public interface RoleModelInt {
	
	/**
	 * add role
	 * @param dto
	 * @return
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
public long add(RoleDto dto)throws ApplicationException,DuplicateRecordException;
/**
 * delete role
 * @param dto
 * @return
 * @throws ApplicationException
 * @throws DuplicateRecordException
 */
public void delete(RoleDto dto)throws ApplicationException;
/**
 * update role
 * @param dto
 * @return
 * @throws ApplicationException
 * @throws DuplicateRecordException
 */
public void update(RoleDto dto)throws ApplicationException,DuplicateRecordException;
/**
 * list of role
 * @param dto
 * @return
 * @throws ApplicationException
 * @throws DuplicateRecordException
 */
public List list()throws ApplicationException;
/**
 * list of role
 * @param dto
 * @return
 * @throws ApplicationException
 * @throws DuplicateRecordException
 */
public List list(int pageNo,int pageSize)throws ApplicationException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * @throws DuplicateRecordException
 */
public List search(RoleDto dto)throws ApplicationException;
/**
 * @param dto
 * @return
 * @throws ApplicationException
 * @throws DuplicateRecordException
 */
public List search(RoleDto dto,int pageNo,int pageSize)throws ApplicationException;
/**
 * @return
 * @throws ApplicationException
 * @throws DuplicateRecordException
 */
public RoleDto findByPK(long pk)throws ApplicationException;
/**
 * @param name
 * @return
 * @throws ApplicationException
 * @throws DuplicateRecordException
 */
public RoleDto findByName(String name)throws ApplicationException;

}
