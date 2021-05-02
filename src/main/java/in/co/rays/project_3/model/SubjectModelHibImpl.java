package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.CourseDTO;
import in.co.rays.project_3.dto.SubjectDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class SubjectModelHibImpl implements SubjectModelInt {

	public long add(SubjectDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		
		CourseModelInt cmodel=ModelFactory.getInstance().getCourseModel();
		CourseDTO cdto=cmodel.findByPK(dto.getCourseId());
		dto.setCourseName(cdto.getCourseName());
		
		SubjectDTO existdto=findByName(dto.getSubjectName());
		if(existdto!=null && existdto.getSubjectName()!=null){
			throw new DuplicateRecordException("Subject already exist");
		}
		
		try {
			session=HibDataSource.getSession();
			tx=session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new ApplicationException("Exception in Subject add "+e.getMessage());
			
		}finally{
			session.close();
		}
		
		
		return dto.getId();
	}

	public void delete(SubjectDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		
		try {
			session =HibDataSource.getSession();
			tx=session.beginTransaction();
			session.delete(dto);
			tx.commit();
					
		} catch (HibernateException e) {
           if(tx!=null){
        	   tx.rollback();
           }
           throw new ApplicationException("Exception in SubjectModel Delete "+ e.getMessage());
		}
		finally {
			session.close();
		}
		
		
	}

	public void update(SubjectDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction tx=null;
		
		CourseModelInt cmodel=ModelFactory.getInstance().getCourseModel();
		CourseDTO cdto=cmodel.findByPK(dto.getCourseId());
		
		dto.setCourseName(cdto.getCourseName());
		
		try {
			session=HibDataSource.getSession();
			tx=session.beginTransaction();
			session.update(dto);
			tx.commit();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
			throw new ApplicationException("Exception in SubjectModel "+ e.getMessage());
		}
		finally{
			session.close();
		}
		
		
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		
		return list(0,0);
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session =null;
		List list=null;
		
		try {
			session =HibDataSource.getSession();
			Criteria criteria=session.createCriteria(SubjectDTO.class);
			
			if(pageSize>0){
				pageNo=(pageNo-1)*pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list=criteria.list();
			
		} catch (HibernateException e) {

		throw new ApplicationException("Exception in subject list "+e.getMessage() );
		
		}finally {
			session.close();
		}
		
		return list;
	}

	public List search(SubjectDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public List search(SubjectDTO dto, int pageNo, int pageSize) throws ApplicationException {

		
		Session session=null;
		List list=null;
		try {
			session=HibDataSource.getSession();
			Criteria criteria=session.createCriteria(SubjectDTO.class);
			if(dto!=null){
			if(dto.getId()!=0){
				criteria.add(Restrictions.eq("id", dto.getId()));
				
			}
			if(dto.getSubjectId()>0){
				criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
			}
			if(dto.getCourseId()>0){
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}
			if(dto.getCourseName()!=null&& dto.getCourseName().length()>0){
				criteria.add(Restrictions.like("courseName", dto.getCourseName()+"%"));
			}
			if(dto.getSubjectName()!=null&& dto.getSubjectName().length()>0){
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName()+"%"));
			}}
			if(pageSize>0){
				criteria.setFirstResult((pageNo-1)*pageSize);
				criteria.setMaxResults(pageSize);
			}
			list=criteria.list();
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  subject search");
		} finally {
			session.close();
		}
		return list;
	}

	public SubjectDTO findByPK(long pk) throws ApplicationException {
		
		Session session=null;
		SubjectDTO dto=null;
		
		try {
			session=HibDataSource.getSession();
			dto=(SubjectDTO) session.get(SubjectDTO.class, pk);
		} catch (HibernateException e) {

		throw new ApplicationException("Exception in subjectModel findByPk "+ e.getMessage());
		
		
		}
		finally{
			session.close();
		}
		return dto;
	}

	public SubjectDTO findByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Session session=null;
		SubjectDTO dto=null;
		
		try {
			session =HibDataSource.getSession();
			Criteria criteria =session.createCriteria(SubjectDTO.class);
			criteria.add(Restrictions.eq("subjectName", name));
			List list=criteria.list();
			
			if(list.size()==1){
				dto=(SubjectDTO) list.get(0);
			}
			
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new ApplicationException("Exception in subjectModel findByName "+ e.getMessage());
			
		}
		finally {
			session.close();
		}
		
		
		return dto;
	}

}
