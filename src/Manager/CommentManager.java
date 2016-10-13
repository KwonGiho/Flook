package Manager;

import java.util.LinkedList;

import DAO.CommentDAO;
import VO.CommentVO;
import ViewVO.CommentViewVO;

public class CommentManager {
	private CommentDAO commentDAO;
	public CommentManager(){
		commentDAO = CommentDAO.getInstance();
	}
	public CommentVO writeComment(String userCode,String commentString, String postCode) {
		return commentDAO.writeComment(userCode, commentString, postCode);
	}
	public int deleteComment(String commentCode) {
		return commentDAO.deleteComment(commentCode);
	}
	/*
	 * ���߿� �� �ڵ� ���־ߵ�..�ð��̾�� �̷��� ����.
	 */
	public LinkedList<CommentViewVO> searchComment(String recipeCode) {
		return commentDAO.searchComment(recipeCode);
	}
}
