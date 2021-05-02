package in.co.rays.project_3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.RoleDto;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class RoleModelHibImpl implements RoleModelInt{

	public long add(RoleDto dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		
		long pk=0;
		RoleDto existdto =findByName(dto.getName());
		if(existdto!=null){
			throw new DuplicateRecordException("Role is already Exist");
			
		}
		session= HibDataSource.getSession();
		try {
			tx=session.beginTransaction();
			session.save(dto);
			pk=dto.getId();
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			//throw new ApplicationException("Exception in roleModelHibImpl add "+e.getMessage());
			e.printStackTrace();
			
		}finally{
			session.close();
		}
		return pk;
	
	}

	public void delete(RoleDto dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session =null;
		Transaction tx=null;
		try {
			session =HibDataSource.getSession();
			tx=session.beginTransaction();
			session.delete(dto);
			
			System.out.println("RoleModel Deleted sucessfully");
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new ApplicationException("Exception in RoleModelHibImpl "+e.getMessage());
		}finally {
			session.close();
		}
		
	}

	public void update(RoleDto dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		
		try {
			session=HibDataSource.getSession();
			tx=session.beginTransaction();
			session.update(dto);
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in RoleModelHinImpl Update "+e.getMessage());
		}
		finally{
			session.close();
		}
		
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=null;
		List list=null;
		try {
			session=HibDataSource.getSession();
			Criteria criteria=session.createCriteria(RoleDto.class);
			if(pageSize>0){
				pageNo=(pageNo-1)*pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list=criteria.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new ApplicationException("Exception in RoleModelHibImpl List "+ e.getMessage());
			
		}finally{
			session.close();
		}
		return list;
	}

	public List search(RoleDto dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public List search(RoleDto dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Session session=null;
		List list=null;
		
		try {
			session=HibDataSource.getSession();
			Criteria criteria=session.createCriteria(RoleDto.class);
			if(dto.getId()>0){
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getName()!=null&& dto.getName().length()>0){
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
			if(dto.getDescription()!=null&& dto.getDescription().length()>0){
				criteria.add(Restrictions.like("description", dto.getDescription()+"%"));
			}
			if(pageSize>0){
				criteria.setFirstResult((pageNo-1)*pageSize);
				criteria.setMaxResults(pageSize);
			}
			list=criteria.list();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new ApplicationException("Exception in Role Search");
		}
		finally {
            session.close();
        }
		
		return list;
	}

	public RoleDto findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=null;
		RoleDto dto=null;
		try {
			session =HibDataSource.getSession();
			dto = (RoleDto) session.get(RoleDto.class, pk);
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new ApplicationException("Exception in RoleModelHibImpl FindByPk "+ e.getMessage());
		}finally{
			session.close();
		}
		return dto;
	}

	public RoleDto findByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		RoleDto dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(RoleDto.class);
			criteria.add(Restrictions.eq("name", name));
			List list = criteria.list();
			if (list.size() > 0) {
				dto = (RoleDto) list.get(0);
			}
		} catch (HibernateException e) {

			throw new ApplicationException("Exception in getting Role by Login " + e.getMessage());

		} finally {
			session.close();
		}
		return dto;
	}
}
