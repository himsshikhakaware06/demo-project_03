package in.co.rays.project_3.dto;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Himshikha
 *
 */


public class UserDTO extends BaseDTO{

	/**
	 * active user
	 */
	public static final String ACTIVE = "Active";
	/**
	 * deactive user
	 */
	public static final String INACTIVE = "Inactive";
	/**
	 *first name of user
	 */
	private String firstName;
	/**
	 * last name of user
	 */
	private String lastName;
	/**
	 * login of user
	 */
	private String login;
	/**
	 *password of user
	 */
	private String password;
	/**
	 *confirm password of user
	 */
	private String confirmPassword;
	/**
	 *date of birth of user
	 */
	private Date dob;
	/**
	 *mobile no of user
	 */
	private String mobileNo;
	/**
	 * unsuccessfull of user
	 */
	private int unSuccessfullLogin;
	/**
	 * gender of user
	 */
	private String gender;
	/**
	 *role id of user
	 */
	private long roleId;
	/**
	 *last login of user
	 */
	private Timestamp lastLogin;
	/**
	 * register ip of user
	 */
	private String registeredIP;
	/**
	 * login ip of user
	 */
	private String loginIP;
    
	/**
	 * get first name
	 * return first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 *  set first name
	 *
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * get last name
	 * return last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 *  set last name
	 *
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
      
	/**
	 * get login
	 * @return login 
	 */
	public String getLogin() {
		return login;
	}
     
	/**
	 * set the login
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * get password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get confirmpassword
	 * @return confirm password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * set confirm password 
	 * @param confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * get the date
	 * @return date
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * set date of birth
	 * @param dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * get mobile no
	 * @return mobile no
	 */
	public String getMobileNo() {
		return mobileNo;
	}
 
	/**
	 * set mobile no
	 * @param mobileNo
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * get UnSuccessfull Login
	 * @return UnSuccessfull Login
	 */
	public int getUnSuccessfullLogin() {
		return unSuccessfullLogin;
	}

	/**
	 *  set UnSuccessfull Login
	 * @param unSuccessfullLogin
	 */
	public void setUnSuccessfullLogin(int unSuccessfullLogin) {
		this.unSuccessfullLogin = unSuccessfullLogin;
	}

	/**
	 * get gender
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * set gender
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * get RoleId
	 * @return RoleId
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * set RoleId
	 * @param roleId
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	/**
	 * get LastLogin
	 * @return LastLogin
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * set LastLogin
	 * @param lastLogin
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * get RegisteredIP
	 * @return RegisteredIP
	 */
	public String getRegisteredIP() {
		return registeredIP;
	}

	/**
	 * set RegisteredIP
	 * @param registeredIP
	 */
	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	/**
	 * get LoginIP
	 * @return LoginIP
	 */
	public String getLoginIP() {
		return loginIP;
	}

	/**
	 * set LoginIP
	 * @param loginIP
	 */
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	

	/**
	 * get Active
	 * @return Active
	 */
	public static String getActive() {
		return ACTIVE;
	}

	/**
	 * get InActive
	 * @return
	 */
	public static String getInactive() {
		return INACTIVE;
	}



	
	public String getKey() {

		return id + " ";
	}

	public String getValue() {

		return firstName + "" + lastName;
	}
	

}
