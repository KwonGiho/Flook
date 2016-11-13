package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Manager.JoinManager;
import Manager.LoginManager;

/**
 * Servlet implementation class JoinServlet
 */
@MultipartConfig
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Part part = request.getPart("join_image_input"); // input �±��� name�� join_image_input�� �ָ� getPart�޼ҵ带 ���Ͽ� ������.
		
		String originalFileName = getFileName(part); // �����̸� get�ؿ��°�!
		String forSaveFileName = getServletContext().getRealPath("")+File.separator+"userImage"+File.separator+originalFileName;//�̰� ��Ŭ���� ������ ������ �����̸��̰�.
		
		part.write(forSaveFileName);//���� ������ ����.
		String dataBaseSaveURLName = File.separator + "Flook"+File.separator+"userImage"+File.separator+originalFileName; // DB�� ������ ����� ������ URL��� ����.
	
		String userName = request.getParameter("join_name_name"); // �̸�
		String userEmail = request.getParameter("join_email_name"); // �̸���
		String userPassword= request.getParameter("join_password_name"); // ��й�ȣ
		String userGender= request.getParameter("sex"); // ����
		String userBirthday= request.getParameter("join_birthday_year")+"/"+request.getParameter("join_birthday_month")+"/"+request.getParameter("join_birthday_day"); // �������
		
		if(new LoginManager().registerCheck(userEmail)==null) {
			JoinManager joinManager =new JoinManager();
			joinManager.joinMember(userName, dataBaseSaveURLName, userEmail, userPassword, userGender, userBirthday);					
			request.setAttribute("joinCheck","ok");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response); 
		} else {
			request.setAttribute("joinError", "fail");
			RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
			rd.forward(request, response);
		}
		
		
	}
	private String getFileName(Part part) 
	{
		String contentDispositionHeader = part.getHeader("content-disposition");
		String name = null;
		String[] elements = contentDispositionHeader.split(";");
		for (String element : elements) {
			System.out.println("element : " + element);
			if (element.trim().startsWith("name")) {
				name = element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");
			} else if (element.trim().startsWith("filename")) {
				return element.substring(element.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

}
