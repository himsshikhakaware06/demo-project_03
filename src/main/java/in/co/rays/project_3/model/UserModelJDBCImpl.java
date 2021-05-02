package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DatabaseException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;
import in.co.rays.project_3.util.JDBCDataSource;

public class UserModelJDBCImpl implements UserModelInt {
	
	private static Logger log=Logger.getLogger(UserModelJDBCImpl.class);
	
	public long nextPK()throws DatabaseException{
		log.debug("userModel nextPk method started");
		
		Connection conn=null;
		long pk=0;
		try {
			conn=JDBCDataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement("select max(id) from ST_USER");
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
	
	

	public long add(UserDTO dto) throws DuplicateRecordException, ApplicationException {
	   
		log.debug("UserModel add method started");
		
		Connection conn=null;
		long pk=0;
		UserDTO existDto=null;
		existDto=findByLogin(dto.getLogin());
		if(existDto!=null){
			throw new DuplicateRecordException("LoginId already exist");
		}
		try {
			conn=JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			pk=nextPK();
			PreparedStatement pstmt=conn.prepareStatement("insert into ST_USER values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		    pstmt.setLong(1, pk);
		    pstmt.setString(2, dto.getFirstName());
		    pstmt.setString(3, dto.getLastName());
		    pstmt.setString(4, dto.getGender());
		    pstmt.setLong(5, dto.getRoleId());
		    pstmt.setDate(6, new java.sql.Date(dto.getDob().getTime()));
		    pstmt.setString(7, dto.getMobileNo());
		    pstmt.setString(8, dto.getLogin());
		    pstmt.setString(9, dto.getPassword());
			pstmt.setString(10, dto.getConfirmPassword());
			pstmt.setTimestamp(11, dto.getLastLogin());
			pstmt.setInt(12, dto.getUnSuccessfullLogin());
			pstmt.setString(13, dto.getLoginIP());
			pstmt.setString(14, dto.getRegisteredIP());
			pstmt.setString(15, dto.getCreatedBy());
			pstmt.setString(16, dto.getModifiedBy());
			pstmt.setTimestamp(17, dto.getCreatedDatetime());
			pstmt.setTimestamp(18, dto.getModifiedDatetime());
		    
			pstmt.executeUpdate();
			
			System.out.println("Data Added Sucessfully");
			conn.commit();
			conn.close();
		
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				log.error(e);
				e2.printStackTrace();
				e.printStackTrace();
				throw new ApplicationException("exception: add rollback exception:" + e2.getMessage());
			}
			throw new ApplicationException("exception in add user");
		}finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("user model add is ended");
		
		return pk;
	}

	public void update(UserDTO dto) throws DuplicateRecordException, ApplicationException {
		// TODO Auto-generated method stub
		Connection conn=null;
		
		UserDTO dtoExist = findByLogin(dto.getLogin());
		// Check if updated LoginId already exist
		if (dtoExist != null && !(dtoExist.getId() == dto.getId())) {
			throw new DuplicateRecordException("LoginId is already exist");
		}
		
		try {
			System.out.println("hguygfiy");
			conn=JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt= conn.prepareStatement("update ST_USER set FIRST_NAME=?,LAST_NAME=?,LOGIN=?,PASSWORD=?,CONFIRMPASSWORD=?,DOB=?,MOBILE_NO=?,ROLE_ID=?,UNSUCCESSFUL_LOGIN=?,GENDER=?,LAST_LOGIN=?,REGISTERED_IP=?,LAST_LOGIN_IP=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			

			pstmt.setString(1, dto.getFirstName());
			pstmt.setString(2, dto.getLastName());
			pstmt.setString(3, dto.getLogin());
			pstmt.setString(4, dto.getPassword());
			pstmt.setString(5, dto.getConfirmPassword());
			pstmt.setDate(6, new java.sql.Date(dto.getDob().getTime()));
			pstmt.setString(7, dto.getMobileNo());
			pstmt.setLong(8, dto.getRoleId());
			pstmt.setInt(9, dto.getUnSuccessfullLogin());
			pstmt.setString(10, dto.getGender());
			pstmt.setTimestamp(11, dto.getLastLogin());
			pstmt.setString(12, dto.getRegisteredIP());
			pstmt.setString(13, dto.getLoginIP());
			pstmt.setString(14, dto.getCreatedBy());
			pstmt.setString(15, dto.getModifiedBy());
			pstmt.setTimestamp(16, dto.getCreatedDatetime());
			pstmt.setTimestamp(17, dto.getModifiedDatetime());
			pstmt.setLong(18, dto.getId());
			pstmt.executeUpdate();
			System.out.println("data update successfully...");
			conn.commit();
			conn.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating User ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update End");
		}
		
	

	public void delete(UserDTO dto) throws DuplicateRecordException, ApplicationException {
		Connection conn=null;
		try {
			conn=JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt=conn.prepareStatement("DELETE from st_user where id=?");
			pstmt.setLong(1, dto.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
			System.out.println("Data deleted sucessfully");

		} catch (Exception e) {
			log.error("Database exception",e);
			try {
				conn.rollback();
			} catch (Exception e2) {
				throw new ApplicationException("Exception : Delete rollback exception " + e2.getMessage());
			}
			// TODO: handle exception
			throw new ApplicationException("Exception : Exception in delete User");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model delete Started");
		
		
	}

	public UserDTO findByLogin(String login) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		UserDTO dto=null;
		
		try {
			conn=JDBCDataSource.getConnection();
			pstmt =conn.prepareStatement("select * from st_user where LOGIN=?");
		   pstmt.setString(1, login);
		   
		   ResultSet rs=pstmt.executeQuery();
		   while(rs.next()){
			 dto=new UserDTO();
			 

				dto.setId(rs.getLong(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setRoleId(rs.getLong(5));
				dto.setDob(rs.getDate(6));
				dto.setMobileNo(rs.getString(7));
				dto.setLogin(rs.getString(8));
				dto.setPassword(rs.getString(9));
				dto.setConfirmPassword(rs.getString(10));
				dto.setLastLogin(rs.getTimestamp(11));	
				dto.setUnSuccessfullLogin(rs.getInt(12));	
				dto.setLoginIP(rs.getString(13));
				dto.setRegisteredIP(rs.getString(14));
				dto.setCreatedBy(rs.getString(15));
				dto.setModifiedBy(rs.getString(16));
				dto.setCreatedDatetime(rs.getTimestamp(17));
				dto.setModifiedDatetime(rs.getTimestamp(18));
		   }
		   System.out.println("findby login");
		   rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting User by login");
		} finally {
			JDBCDataSource.closeConnection(conn);
		
		}
		log.debug("Model findByLogin End");
		return dto;
	}

	public UserDTO findByPk(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		UserDTO dto=null;
		
		try {
			conn=JDBCDataSource.getConnection();
			pstmt=conn.prepareStatement("select * from st_user where id=?");
			pstmt.setLong(1, pk);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				   dto = new UserDTO();
				   dto.setId(rs.getLong(1));
					dto.setFirstName(rs.getString(2));
					dto.setLastName(rs.getString(3));
					dto.setGender(rs.getString(4));
					dto.setRoleId(rs.getLong(5));
					dto.setDob(rs.getDate(6));
					dto.setMobileNo(rs.getString(7));
					dto.setLogin(rs.getString(8));
					dto.setPassword(rs.getString(9));
					dto.setConfirmPassword(rs.getString(10));
					dto.setLastLogin(rs.getTimestamp(11));	
					dto.setUnSuccessfullLogin(rs.getInt(12));	
					dto.setLoginIP(rs.getString(13));
					dto.setRegisteredIP(rs.getString(14));
					dto.setCreatedBy(rs.getString(15));
					dto.setModifiedBy(rs.getString(16));
					dto.setCreatedDatetime(rs.getTimestamp(17));
					dto.setModifiedDatetime(rs.getTimestamp(18));
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting UserJDBCImpl findBypk");
		}
		finally{ 
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("UserModel findByPk end");
		return dto;
	}

	public List search(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ArrayList list=null;
		StringBuffer sql=new StringBuffer("Select * from st_user where 1=1");
		

		if (dto != null) {
			if (dto.getId() > 0) {
				sql.append(" AND ID = " + dto.getId());
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append(" AND FIRSTNAME like '" + dto.getFirstName() + "%'");
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				sql.append(" AND LASTNAME like '" + dto.getLastName() + "%'");
			}
			if (dto.getLogin() != null && dto.getLogin().length() > 0) {
				sql.append(" AND LOGIN like '" + dto.getLogin() + "%'");
			}
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				sql.append(" AND PASSWORD like '" + dto.getPassword() + "%'");
			}
			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				sql.append(" AND DOB = " + dto.getGender());
			}
			if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
				sql.append(" AND MOBILENO = " + dto.getMobileNo());
			}
			if (dto.getRoleId() > 0) {
				sql.append(" AND ROLEID = " + dto.getRoleId());
			}
			if (dto.getUnSuccessfullLogin() > 0) {
				sql.append(" AND UNSUCCESSFULLOGIN = " + dto.getUnSuccessfullLogin());
			}
			if (dto.getGender() != null && dto.getGender().length() > 0) {
				sql.append(" AND GENDER like '" + dto.getGender() + "%'");
			}
			if (dto.getLastLogin() != null && dto.getLastLogin().getTime() > 0) {
				sql.append(" AND LASTLOGIN = " + dto.getLastLogin());
			}
			if (dto.getRegisteredIP() != null && dto.getRegisteredIP().length() > 0) {
				sql.append(" AND REGISTEREDIP like '" + dto.getRegisteredIP() + "%'");
			}
			if (dto.getLoginIP() != null && dto.getLoginIP().length() > 0) {
				sql.append(" AND LOGINIP like '" + dto.getLoginIP() + "%'");
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append("limit" + pageNo + "," + pageSize);
		}
		list = new ArrayList();
		try {
			conn = JDBCDataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getLong(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setRoleId(rs.getLong(5));
				dto.setDob(rs.getDate(6));
				dto.setMobileNo(rs.getString(7));
				dto.setLogin(rs.getString(8));
				dto.setPassword(rs.getString(9));
				dto.setConfirmPassword(rs.getString(10));
				dto.setLastLogin(rs.getTimestamp(11));	
				dto.setUnSuccessfullLogin(rs.getInt(12));	
				dto.setLoginIP(rs.getString(13));
				dto.setRegisteredIP(rs.getString(14));
				dto.setCreatedBy(rs.getString(15));
				dto.setModifiedBy(rs.getString(16));
				dto.setCreatedDatetime(rs.getTimestamp(17));
				dto.setModifiedDatetime(rs.getTimestamp(18));
				list.add(dto);
			}
			rs.close();

		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in search user");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model search End");
		return list;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ArrayList list=null;
		UserDTO dto=null;
		StringBuffer sql=new StringBuffer("select * from st_user where 1=1");
		
		if(pageSize>0){
			pageNo= (pageNo-1)*pageSize;
			sql.append("limit" + pageNo + "," + pageSize);
		}
		try {
			conn = JDBCDataSource.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getLong(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setRoleId(rs.getLong(5));
				dto.setDob(rs.getDate(6));
				dto.setMobileNo(rs.getString(7));
				dto.setLogin(rs.getString(8));
				dto.setPassword(rs.getString(9));
				dto.setConfirmPassword(rs.getString(10));
				dto.setLastLogin(rs.getTimestamp(11));	
				dto.setUnSuccessfullLogin(rs.getInt(12));	
				dto.setLoginIP(rs.getString(13));
				dto.setRegisteredIP(rs.getString(14));
				dto.setCreatedBy(rs.getString(15));
				dto.setModifiedBy(rs.getString(16));
				dto.setCreatedDatetime(rs.getTimestamp(17));
				dto.setModifiedDatetime(rs.getTimestamp(18));
				list.add(dto);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting list of users");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug("Model list End");
		
		
		return list;
	}

	public boolean changePassword(Long id, String oldPassword, String newPassword)
			throws RecordNotFoundException, ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	public UserDTO authenticate(String login, String password) throws ApplicationException {
		// TODO Auto-generated method stub
		log.debug("user model authenticate method start");
		UserDTO dto = null;
		Connection conn = null;
		StringBuffer sql = new StringBuffer("select * from ST_USER where login=? and password=?");
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getLong(1));
				dto.setFirstName(rs.getString(2));
				dto.setLastName(rs.getString(3));
				dto.setGender(rs.getString(4));
				dto.setRoleId(rs.getLong(5));
				dto.setDob(rs.getDate(6));
				dto.setMobileNo(rs.getString(7));
				dto.setLogin(rs.getString(8));
				dto.setPassword(rs.getString(9));
				dto.setConfirmPassword(rs.getString(10));
				dto.setLastLogin(rs.getTimestamp(11));	
				dto.setUnSuccessfullLogin(rs.getInt(12));	
				dto.setLoginIP(rs.getString(13));
				dto.setRegisteredIP(rs.getString(14));
				dto.setCreatedBy(rs.getString(15));
				dto.setModifiedBy(rs.getString(16));
				dto.setCreatedDatetime(rs.getTimestamp(17));
				dto.setModifiedDatetime(rs.getTimestamp(18));

			}
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in get roles");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.debug(" user Model authenticate End");
		return dto;
	}

	public boolean lock(String login) throws RecordNotFoundException, ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	public List getRoles(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO updateAccess(UserDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return null;
	}

	public long registerUser(UserDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean resetPassword(UserDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean forgetPassword(String login) throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

}
