package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Manager.NewsFeedManager;
import ViewVO.FollowLikeRecipeViewVO;
import ViewVO.NewsfeedLatestOrderViewVO;

/**
 * Servlet implementation class NewsFeedServlet
 */
public class NewsFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*doGet(request, response);*/
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession(); // ���� �޾ƿͼ�
		
		String userCode = (String) session.getAttribute("userCode");//���ǿ��� �����ڵ� �޾ƿ�.
		//String userCode="code1";

		
		NewsFeedManager newsFeedManager = new NewsFeedManager(); // �����ǵ� �Ŵ��� ����.
		ArrayList<NewsfeedLatestOrderViewVO> array = newsFeedManager.requestLatestOrder(userCode);
		request.setAttribute("newsfeedLatestArray", array);
		ArrayList<FollowLikeRecipeViewVO> map = newsFeedManager.requestPopularOrder(userCode);
		request.setAttribute("newsfeedPopularArray",map);
		RequestDispatcher view = request.getRequestDispatcher("newspeed.jsp");
		view.forward(request, response);
	}
}
