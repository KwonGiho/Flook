package Manager;

import java.util.ArrayList;
import java.util.LinkedList;

import ViewDAO.SimpleUserRecipeViewDAO;
import ViewVO.SimpleUserRecipeViewVO;

public class UserRecipeManager {
   private SimpleUserRecipeViewDAO simpleUserRecipeViewDAO;
   public UserRecipeManager() {
      simpleUserRecipeViewDAO = SimpleUserRecipeViewDAO.getInstance();
   }
   public LinkedList<SimpleUserRecipeViewVO> searchUserRecipeList(String method,String situation,String nation,String ingredient,String kindOf) {
      return simpleUserRecipeViewDAO.searchUserRecipeList(method,situation,nation,ingredient,kindOf);
   }
   /**
    * �����丵 �� �Ʒ��޼ҵ�� �ش��ϴ� �������� ����.
    * @return
    */
   public ArrayList<SimpleUserRecipeViewVO> searchUserRecipeList(){
      return simpleUserRecipeViewDAO.searchUserRecipeList();
   }
   /*public UserRecipeManager() {
      simpleUserRecipeViewDAO = SimpleUserRecipeViewDAO.getInstance();
   }
   public LinkedList<SimpleUserRecipeViewVO> requestSimpleUserRecipeList(String userCode) {
      return simpleUserRecipeViewDAO.requestSimpleUserRecipeList(userCode);
   }*/
}