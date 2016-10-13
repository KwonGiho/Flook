package Manager;

import java.util.LinkedList;

import DAO.ScrapDAO;
import VO.ScrapVO;

public class ScrapManager {
	private ScrapDAO scrapDAO;
	public ScrapManager() {
		// TODO Auto-generated constructor stub
		scrapDAO=ScrapDAO.getInstance();
	}
	public int insertScrap(String userCode,String postCode)
	{ 
		return scrapDAO.insertScrap(userCode, postCode);
	}
	public int deleteScrap(String userCode,String postCode)
	{
		return scrapDAO.deleteScrap(userCode, postCode);
	} 
	public ScrapVO searchScrap(String userCode,String postCode)
	{
		return scrapDAO.searchScrap(userCode, postCode);//�Ⱦ��� ������ �ϴ� ����
	}
	public LinkedList<ScrapVO> searchScrapList(String userCode)
	{
		return scrapDAO.searchScrapList(userCode);
	}

}
