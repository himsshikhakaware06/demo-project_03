package in.co.rays.project_3.dto;

import java.util.Date;

public class FacultyDTO extends BaseDTO{
	 /**
     * name of faculty
     */
    private String firstName;
    /**
     * last name  of faculty
     */
    private String lastName;
    /**
     * gender of faculty
     */
    private String gender;
    /**
     * quealification of faculty
     */
    private String qualification;
    /**
     * mobile no of faculty
     */
    private String mobileNo;
    /**
     *mobile no of faculty
     */
    private String emailId;
    /**
     * email id vof faculty
     */
    
    private Date dob;
    /**
     * dob of faculty
     */
    private long collegeId;
    /**
     * course id of faculty
     */
    private long courseId;
    /**
     * subject id of faculty
     */
    private long subjectId;
    /**
     *college Name of faculty
     */
    private String collegeName;
    /**
     *course Name of faculty
     */
    private String courseName;
    /**
     * subjectName of faculty
     */
    private String subjectName;
    
    /**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
    
	public String getFirstName() {
		return firstName;
	}
       
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */

	public String getLastName() {
		return lastName;
	}
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return firstName;
	}


}
