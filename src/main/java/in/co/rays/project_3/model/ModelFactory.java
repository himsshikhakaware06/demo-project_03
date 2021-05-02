package in.co.rays.project_3.model;

import java.util.ResourceBundle;
import java.util.HashMap;


public class ModelFactory {
	
	 private static ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.System");
	 
	 private static final String DATABASE=rb.getString("DATABASE");
	 private static ModelFactory mFactory=null;
	 

	    /**
	     * Cache of Model classes
	     */
	 private static HashMap modelCache = new HashMap();

	    /**
	     * Constructor is private so no other class can create instance of Model
	     * Locator
	     */
	    private ModelFactory() {

	    }

	    /**
	     * Get the instance of Model Locator
	     *
	     * @return mFactory
	     */
	    public static ModelFactory getInstance() {
	        if (mFactory == null) {
	            mFactory = new ModelFactory();
	        }
	        return mFactory;
	    }
	    
	    
	    /**
	     * Get instance of Marksheet Model
	     *
	     * @return marksheetModel
	     */
	    public FacultyModelInt getFacultyModel() {
	    	FacultyModelInt facultyModel = (FacultyModelInt)modelCache
	                .get("facultyModel");
	        if (facultyModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	            	facultyModel = new FacultyModelHibImpl();
	            }
	            if ("JDBC".equals(DATABASE)) {
	            	facultyModel = new FacultyModelHibImpl();
	            }
	            modelCache.put("facultyModel", facultyModel);
	        }

	        return facultyModel;
	    }

	    
	  public TimeTableModelInt getTimeTableModel() {
	    	TimeTableModelInt timeTableModel = (TimeTableModelInt) modelCache.get("timeTableModel");
	        if (timeTableModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	            	timeTableModel = new TimeTableModelHibImpl();
	            }
	            if ("JDBC".equals(DATABASE)) {
	              //  marksheetModel = new MarksheetModelJDBCImpl();
	            }
	            modelCache.put("timeTableModel", timeTableModel);
	        }

	        return timeTableModel;
	    }
	   
	    

	    /**
	     * Get instance of Marksheet Model
	     *
	     * @return marksheetModel
	     */
	   public MarksheetModelInt getMarksheetModel() {
	        MarksheetModelInt marksheetModel = (MarksheetModelInt) modelCache
	                .get("marksheetModel");
	        if (marksheetModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	                marksheetModel = new MarksheetModelHibImpl();
	            }
	            if ("JDBC".equals(DATABASE)) {
	                marksheetModel = new MarksheetModelJDBCImpl();
	            }
	            modelCache.put("marksheetModel", marksheetModel);
	        }

	        return marksheetModel;
	    }
	    /**
	     * Get instance of Marksheet Model
	     *
	     * @return marksheetModel
	     */
	   
	   public CourseModelInt getCourseModel() {
	    	CourseModelInt CourseModel = (CourseModelInt) modelCache.get("CourseModel");
	        if (CourseModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	            	CourseModel = new CourseModelHibImpl();
	            }
	            if ("JDBC".equals(DATABASE)) {
	               CourseModel =new CourseModelJDBCImpl();
	            }
	            modelCache.put("CourseModel", CourseModel);
	        }

	        return CourseModel;
	    }

	    
	   public SubjectModelInt getSubjectModel() {
	    	SubjectModelInt SubjectModel = (SubjectModelInt)modelCache.get("SubjectModel");
	        if (SubjectModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	            	SubjectModel = new SubjectModelHibImpl();
	            }
	            if ("JDBC".equals(DATABASE)) {
	            	SubjectModel = new SubjectModelJDBCImpl();
	            }
	            modelCache.put("SubjectModel", SubjectModel);
	        }

	        return SubjectModel;
	    }

	    /**
	     * Get instance of User Model
	     *
	     * @return userModel
	     */
	    public UserModelInt getUserModel() {
	        UserModelInt userModel = (UserModelInt) modelCache.get("userModel");
	        if (userModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	                userModel = new UserModelHibImpl();
	            }
//	            if ("JDBC".equals(DATABASE)) {
//	                userModel = new UserModelJDBCImpl();
//	            }
	            modelCache.put("userModel", userModel);
	        }

	        return userModel;
	    }

	    /**
	     * Get instance of Collage Model
	     *
	     * @return collage
	     */
	    public CollegeModelInt getCollegeModel() {
	        CollegeModelInt collegeModel = (CollegeModelInt) modelCache
	                .get("collegeModel");
	        if (collegeModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	                collegeModel = new CollegeModelHibImpl();
	            }
	            if ("JDBC".equals(DATABASE)) {
	                collegeModel = new CollegeModelJDBCImpl();
	            }
	            modelCache.put("collegeModel", collegeModel);
	        }

	        return collegeModel;
	    }

	    /**
	     * Get instance of Student Model
	     *
	     * @return Student
	     */
	    public StudentModelInt getStudentModel() {
	        StudentModelInt studentModel = (StudentModelInt) modelCache
	                .get("StudentModel");
	        if (studentModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	                studentModel = new StudentModelHibImpl();
	            }
	            if ("JDBC".equals(DATABASE)) {
	                studentModel = new StudentModelJDBCImpl();
	            }
	            modelCache.put("studentModel", studentModel);
	        }

	        return studentModel;
	    }

	    /**
	     * Get instance of Role Model
	     *
	     * @return Student
	     */
	   public RoleModelInt getRoleModel() {
	        RoleModelInt roleModel = (RoleModelInt) modelCache.get("roleModel");
	        if (roleModel == null) {
	            if ("Hibernate".equals(DATABASE)) {
	                roleModel = new RoleModelHibImpl();
	            }
	            if ("JDBC".equals(DATABASE)) {
	                roleModel = new RoleModelJDBCImpl();
	            }
	            modelCache.put("roleModel", roleModel);
	        }

	        return roleModel;

	    }


}
