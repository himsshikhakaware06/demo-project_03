package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.CollegeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class CollegeModelHibImpl implements CollegeModelInt{

	public long add(CollegeDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		CollegeDTO duplicateCollegeName = fingByName(dto.getName());
		System.out.println(",.........."+duplicateCollegeName);
		if (duplicateCollegeName != null) {
			throw new DuplicateRecordException("college name already exist");
		}
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in college Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();
	}

	public void delete(CollegeDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session =null;
		Transaction tx=null;
		try {
			session=HibDataSource.getSession();
			tx=session.beginTransaction();
			session.delete(dto);
			tx.commit();
			System.out.println("Data deleted sucessfully");
		} catch (HibernateException e) {
			// TODO: handle exception
			if(tx!=null){
				tx.rollback();
			}
			throw new ApplicationException("Exception in CollegeModelHibImpl delete "+ e.getMessage());
		}finally{
			session.close();
		}
		
	}

	public void update(CollegeDTO dto) throws ApplicationException, DuplicateRecordException {
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
			if(tx!=null){
				tx.rollback();
			}
			throw new ApplicationException("Exception in CollegeModelHibImpl Update "+e.getMessage());
		}finally{
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
			Criteria criteria=session.createCriteria(CollegeDTO.class);
			if(pageSize>0){
				pageNo=(pageNo-1)*pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
				
			}
			list=criteria.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new ApplicationException("Exception in CollegeModel List "+ e.getMessage());
			
		}finally{
			session.close();
		}
		
		return list;
	}

	public List search(CollegeDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public List search(CollegeDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=null;
		List list=null;
		
		try {
			session=HibDataSource.getSession();
			Criteria criteria=session.createCriteria(CollegeDTO.class);
			
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if(dto.getName()!=null&&dto.getName().length()>0){
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
			if(dto.getAddress()!=null&&dto.getAddress().length()>0){
				criteria.add(Restrictions.like("address", dto.getAddress()+"%"));
			}
			if(dto.getState()!=null&&dto.getState().length()>0){
				criteria.add(Restrictions.like("state", dto.getState()+"%"));
			}
			if(dto.getCity()!=null&&dto.getCity().length()>0){
				criteria.add(Restrictions.like("city", dto.getCity()+"%"));
			}
			
			if (pageSize>0) {
				pageNo=(pageNo-1)*pageSize;
				criteria.setFirstResult(pageNo);
			    criteria.setMaxResults(pageSize);	
			}
			list=criteria.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new ApplicationException("Exception in CollegeModel Search "+ e.getMessage());
		}finally{
			session.close();
		}		
		return list;
	}

	public CollegeDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=null;
		CollegeDTO dto=null;
		try {
			session=HibDataSource.getSession();
			dto=(CollegeDTO) session.get(CollegeDTO.class, pk);
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new ApplicationException("Exception in college FindByPk "+e.getMessage());
		}
		finally{
			session.close();
		}
		return dto;
	}

	public CollegeDTO fingByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=null;
		List list=null;
		CollegeDTO dto=null;
		
		try {
			session=HibDataSource.getSession();
			Criteria criteria=session.createCriteria(CollegeDTO.class);
			criteria.add(Restrictions.eq("name",name ));
		list =criteria.list();
		if(list.size()>0){
			dto=(CollegeDTO) list.get(0);
		}	
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new ApplicationException("Exception in CollegeModel FindByName "+e.getMessage());
			
		}finally{
			session.close();
		}
		
		return dto;
	}

}
