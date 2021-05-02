package in.co.rays.project_3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.project_3.dto.RoleDto;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.JDBCDataSource;

public class RoleModelJDBCImpl implements RoleModelInt {
	private static Logger log=Logger.getLogger(RoleModelJDBCImpl.class);
	
	/**
	 * create id 
	 * @return pk
	 * @throws DatabaseException
	 */
	public long nextPK()throws DatabaseException{
		log.debug("userModel nextPk method started");
		
		Connection conn=null;
		long pk=0;
		try {
			conn=JDBCDataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement("select max(id) from st_role");
			ResultSet rs=ps.executeQuery();
			while (rs.next()){
				pk=rs.getLong(1);
				
			}
			
		} catch (Exception e) {
			log.error(e);
			throw new DatabaseException("Database Exception" + e);
		}
		log.debug("user pk is end");
		return pk+1;
		
	}

	public long add(RoleDto dto) throws ApplicationException, DuplicateRecordException {

		Connection con = null;
		long pk = 0;
		RoleDto duplicataRole = findByName(dto.getName());
		if (duplicataRole != null) {
			throw new DuplicateRecordException("Role already exists");
		}
		try {
			System.out.println("<<<");
			pk=nextPK();
			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("insert into st_role values(?,?,?,?,?,?,?)");
			pstmt.setLong(1, pk);
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getDescription());
			pstmt.setString(4, dto.getCreatedBy());
			pstmt.setString(5, dto.getModifiedBy());
			pstmt.setTimestamp(6, dto.getCreatedDatetime());
			pstmt.setTimestamp(7, dto.getModifiedDatetime());
			int a = pstmt.executeUpdate();
			System.out.println("insert data" + a);
			pstmt.close();
			con.commit();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				con.rollback();
			} catch (Exception ex) {
				//throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			e.printStackTrace();
			}
			throw new ApplicationException("Exception : Exception in add Role");
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		log.debug("RoleModel add End");
		return pk;
	}

	public void delete(RoleDto dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {

			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("delete from st_role where ID=?");
			ps.setLong(1, dto.getId());
			System.out.println("Delete data successfully");
			ps.executeUpdate();
			ps.close();
			con.commit();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				con.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete roleO");
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		log.debug("Model delete Started");
	} 
	

		
	

	public void update(RoleDto dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Connection con = null;
		RoleDto duplicataRole = findByName(dto.getName());
		if (duplicataRole != null && duplicataRole.getId() != dto.getId()) {
			throw new DuplicateRecordException("Role already exists");
		}
		try {

			con = JDBCDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"update st_role set NAME=?,DESCRIPTION=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? where ID=?");
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getDescription());
			ps.setString(3, dto.getCreatedBy());
			ps.setString(4, dto.getModifiedBy());
			ps.setTimestamp(5, dto.getCreatedDatetime());
			ps.setTimestamp(6, dto.getModifiedDatetime());
			ps.setLong(7, dto.getId());

			System.out.println("update data successfully");
			ps.executeUpdate();
			ps.close();
			con.commit();

		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				con.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating role ");
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);		
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		log.debug("Model list Started");
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from st_role");
		if(pageSize>0){
			pageNo=(pageNo-1)*pageSize;
			sql.append("limit"+pageNo+","+pageSize);
		}
		
		Connection conn = null;
		RoleDto dto=null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				 dto = new RoleDto();
				dto.setId(rs.getLong(1));
				dto.setName(rs.getString(2));
				dto.setDescription(rs.getString(3));
				dto.setCreatedBy(rs.getString(4));
				dto.setModifiedBy(rs.getString(5));
				dto.setCreatedDatetime(rs.getTimestamp(6));
				dto.setModifiedDatetime(rs.getTimestamp(7));
				list.add(dto);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting list of Role");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model list End");
		return list;
		
	
	}

	public List search(RoleDto dto) throws ApplicationException {
		// TODO Auto-generated method stub
		
		
		return search(dto, 0, 0);
	}

	public List search(RoleDto dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		 StringBuffer sql = new StringBuffer("select * from st_role where 1=1");
		 if (dto != null) {
		        if (dto.getId() > 0) {
		            sql.append(" AND ID = " + dto.getId());
		        }
		        if (dto.getName() != null && dto.getName().length() > 0) {
		            sql.append(" AND NAME like '" + dto.getName() + "%'");
		        }
		       
		    }
		 if (pageSize > 0) {
		        // Calculate start record index
		        pageNo = (pageNo - 1) * pageSize;

		        sql.append(" Limit " + pageNo + ", " + pageSize);
		        // sql.append(" limit " + pageNo + "," + pageSize);
		    }

		    System.out.println(sql);
		    ArrayList<RoleDto> list = new ArrayList<RoleDto>();
		    Connection conn = null;
		    try {
		        conn = JDBCDataSource.getConnection();
		        PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		        ResultSet rs = pstmt.executeQuery();
		        while (rs.next()) 
		        {
		        	
		            dto = new RoleDto();
		            dto.setId(rs.getLong(1));
		            dto.setName(rs.getString(2));
		            dto.setDescription(rs.getString(3));
	         

		            list.add(dto);
		        }
		        rs.close();
		    } catch (Exception e) {
		    	throw new ApplicationException("exception in role model  search"+e.getMessage());
		    } finally {
		        JDBCDataSource.closeConnection(conn);
		    }

		    //log.debug("Model search End");
		    return list;
	
	}

	public RoleDto findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt =null;
		RoleDto dto=null;
		
		try {
			conn=JDBCDataSource.getConnection();
			pstmt=conn.prepareStatement("SELECT * from st_role where ID=?");
			pstmt.setLong(1, pk);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				 dto=new RoleDto();
				dto.setId(rs.getLong(1));
				dto.setName(rs.getString(2));
				dto.setDescription(rs.getString(3));
			}
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("DataBase Exception ...",e);
			throw new ApplicationException("Exception in RoleModelJdbc "+e.getMessage());
		}
		 finally {
				JDBCDataSource.closeConnection(conn);
			}
			log.debug("model findBy pk end");

			return dto;
		
		
	
	}

	public RoleDto findByName(String name) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection con = null;
		RoleDto dto = null;
		try {

			con = JDBCDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_role where NAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new RoleDto();
				dto.setId(rs.getLong(1));
				dto.setName(rs.getString(2));
				dto.setDescription(rs.getString(3));

			}
			ps.close();

		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting User by emailId");
		} finally {
			JDBCDataSource.closeConnection(con);
		}
		log.debug("Model findBy EmailId End");
		return dto;
	}
	
	

}
