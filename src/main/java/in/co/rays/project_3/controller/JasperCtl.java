package in.co.rays.project_3.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.impl.SessionImpl;

import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.util.HibDataSource;
import in.co.rays.project_3.util.JDBCDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class Jasper
 * 
 *  
 * @author Session Facade
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@WebServlet({"/ctl/JasperCtl"})
public class JasperCtl extends BaseCtl {
	
	public JasperCtl() {
		super(); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DoGet Jasper Report");
		try {
			
			System.out.println("DoGet Jasper Report try block");
			JasperReport jasperReport = JasperCompileManager
					.compileReport("F:\\project\\project_3\\project_3\\src\\main\\webapp\\report\\final_report.jrxml");
			
			HttpSession session = request.getSession(true);
			UserDTO dto = (UserDTO) session.getAttribute("user");
			dto.getFirstName();
			dto.getLastName();
			
			Map<String, Object> map = new HashMap();
			map.put("user", dto.getFirstName() + " " + dto.getLastName());
			Connection conn = null;
			System.out.println("DoGet Jasper Report 11111");
			ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.project_3.bundle.System");
			
			String Database = rb.getString("DATABASE");
			if ("Hibernate".equalsIgnoreCase(Database)) {
				conn = ((SessionImpl)HibDataSource.getSession()).connection();
			}

			if ("JDBC".equalsIgnoreCase(Database)) {
				conn = JDBCDataSource.getConnection();
			}

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
			response.setContentType("application/pdf");
			response.getOutputStream().write(pdf);
			response.getOutputStream().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected String getView() {
		return null;
	}
}