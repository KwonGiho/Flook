package Manager;

import java.util.LinkedList;

import ViewDAO.SimpleUserRecipeViewDAO;
import ViewVO.SimpleUserRecipeViewVO;

public class RecommendSituationManager {
	//������ ������ �ƴ϶� flook�����Ƿ��߾������ �ߴ�.
	
	private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO= SimpleUserRecipeViewDAO.getInstance();
	
	public RecommendSituationManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RecommendSituationManager(
			SimpleUserRecipeViewDAO simpleUserRecipeViewDAO) {
		this.simpleUserRecipeViewDAO = simpleUserRecipeViewDAO;
	}


	public LinkedList<SimpleUserRecipeViewVO> searchSituation(String situationName){
		return simpleUserRecipeViewDAO.searchSituation(situationName);
	}
	
	

}
