package Servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Manager.RecommendTodayManager;
import ViewVO.SimpleUserRecipeViewVO;

/**
 * Servlet implementation class RecommendTodayServlet
 */
public class RecommendTodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		RecommendTodayManager recommendTodayManager = new RecommendTodayManager();
		//���� �����ϱ����ؼ� ����.
		Calendar calendar = Calendar.getInstance();
		//�������� today���� ����������.
		String today = calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.DATE)-1);
		LinkedList<String> stringList=recommendTodayManager.searchUserRecipeList(today);
		LinkedList<SimpleUserRecipeViewVO> simpleUserList = new LinkedList<SimpleUserRecipeViewVO>();
		
		for(int i=0;i<stringList.size();i++){
			simpleUserList.add(recommendTodayManager.searchPostCodeRecipeList(stringList.get(i)));
			System.out.println("completeImage="+simpleUserList.get(i).getCompleteImage());
		}
		request.setAttribute("todayRecipeRecommend", simpleUserList);
		RequestDispatcher rd = request.getRequestDispatcher("todayRecipeRecommend.jsp");
		
		rd.forward(request, response);
	}
	

}
