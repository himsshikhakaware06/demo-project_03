package in.co.rays.project_3.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.ServletUtility;

public abstract class BaseCtl extends HttpServlet {
	

	/**
	 * The Constant OP_SAVE.
	 */
	public static final String OP_SAVE = "Save";
	
	/**
	 * The Constant OP_CANCEL.
	 */
	public static final String OP_CANCEL = "Cancel";
	
	/**
	 * The Constant OP_DELETE.
	 */
	public static final String OP_DELETE = "Delete";
	
	/**
	 * The Constant OP_RESET.
	 */
	public static final String OP_RESET = "Reset";
	
	/**
	 * The Constant OP_LIST.
	 */
	public static final String OP_LIST = "List";
	
	/**
	 * The Constant OP_SEARCH.
	 */
	public static final String OP_SEARCH = "Search";
	
	/**
	 * The Constant OP_VIEW.
	 */
	public static final String OP_VIEW = "View";
	
	/**
	 * The Constant OP_NEXT.
	 */
	public static final String OP_NEXT = "Next";
	
	/**
	 * The Constant OP_PREVIOUS.
	 */
	public static final String OP_PREVIOUS = "Previous";
	
	/**
	 * The Constant OP_NEW.
	 */
	public static final String OP_NEW = "New";
	
	/**
	 * The Constant OP_GO.
	 */
	public static final String OP_GO = "Go";
	
	/**
	 * The Constant OP_PRINT.
	 */
	public static final String OP_PRINT = "Print";
	
	/**
	 * The Constant OP_BACK.
	 */
	public static final String OP_BACK = "Back";
	
	/**
	 * The Constant OP_UPDATE.
	 */
	public static final String OP_UPDATE = "Update";
	
	/**
	 * The Constant OP_LOG_OUT.
	 */
	public static final String OP_LOG_OUT = "Logout";
	
	/**
	 * The Constant OP_CHANGE_MY_PROFILE.
	 */
	public static final String OP_CHANGE_MY_PROFILE = "MyProfile";

    /**
     * Success message key constant
     */
    public static final String MSG_SUCCESS = "success";

    /**
     * Error message key constant
     */
    public static final String MSG_ERROR = "error";

    /**
     * Validates input data entered by User
     *
     * @param request
     * @return
     */
    protected boolean validate(HttpServletRequest request) {
        return true;
    }

    /**
     * Loads list and other data required to display at HTML form
     *
     * @param request
     */
    protected void preload(HttpServletRequest request) {
    }

    /**
     * Populates DTO object from request parameters
     *
     * @param request
     * @return
     */
    protected BaseDTO populateDTO(HttpServletRequest request) {
        return null;
    }

    
    
    protected BaseDTO populateBean(BaseDTO dto, HttpServletRequest request) {

		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;

		UserDTO userbean = (UserDTO) request.getSession().getAttribute("user");

		if (userbean == null) {
			// If record is created without login
			createdBy = "root";
			modifiedBy = "root";
		} else {

			modifiedBy = userbean.getLogin();

			// If record is created first time
			if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}

		}

		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			dto.setCreatedDatetime(DataUtility.getTimeStamp(cdt));
		} else {
			dto.setCreatedDatetime(DataUtility.getCurrentTimeStamp());
		}

		dto.setModifiedDatetime(DataUtility.getCurrentTimeStamp());

		return dto;
	}

    
    
    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // Load the preloaded data required to display at HTML form
        preload(request);

        String op = DataUtility.getString(request.getParameter("operation"));
        
        System.out.println("BaseCtl Operation:"+ op);

        // Check if operation is not DELETE, VIEW, CANCEL, and NULL then
        // perform input data validation

        if (DataValidator.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op) && !OP_VIEW.equalsIgnoreCase(op)
				&& !OP_DELETE.equalsIgnoreCase(op)&& !OP_RESET.equalsIgnoreCase(op)) {
            // Check validation, If fail then send back to page with error
            // messages

            if (!validate(request)) {
                BaseDTO dto = (BaseDTO) populateDTO(request);
                ServletUtility.setDto(dto, request);
                ServletUtility.forward(getView(), request, response);
                return;
            }
        }
        super.service(request, response);
        System.out.println("lkjkljkl");
    }

    /**
     * Returns the VIEW page of this Controller
     *
     * @return
     */
    protected abstract String getView();

}
