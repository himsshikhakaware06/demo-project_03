package in.co.rays.project_3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.project_3.dto.CourseDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.JDBCDataSource;

public class CourseModelJDBCImpl implements CourseModelInt{
	
	private static Logger log = Logger.getLogger(CourseModelJDBCImpl.class);
	Connection con = null;
	PreparedStatement ps = null;

	
	public long nextPK() throws DatabaseException {
		long pk = 0;
		log.debug("model nextPk start");

		try {
			con = JDBCDataSource.getConnection();
			ps = con.prepareStatement("select max(ID) from st_course");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getLong(1);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			log.error("Database Exception", e);
			throw new DatabaseException("Exception getting in pk");
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		log.debug("model nextpk end");
		return pk + 1;

	}

	public long add(CourseDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub

		long pk = 0;
		log.debug("model add start");
		CourseDTO duplicataRole = findByName(dto.getCourseName());
		// Check if create Role already exist
		if (duplicataRole != null) {
			throw new DuplicateRecordException("Course already exists");
		}

		String query = "insert into st_course values(?,?,?,?,?,?,?,?)";
		try {
			pk = nextPK();
			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, pk);
			ps.setString(2, dto.getCourseName());
			ps.setString(3, dto.getDuration());
			ps.setString(4, dto.getDescription());

			ps.setString(5, dto.getCreatedBy());
			ps.setString(6, dto.getModifiedBy());
			ps.setTimestamp(7, dto.getCreatedDatetime());
			ps.setTimestamp(8, dto.getModifiedDatetime());

			int a = ps.executeUpdate();
			System.out.println("ok:");
			ps.close();
			con.commit();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				con.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add Student");
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		log.debug("Model add End");
		return 0;
	}

	public void delete(CourseDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
	}

	public void update(CourseDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(CourseDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(CourseDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public CourseDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public CourseDTO findByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
