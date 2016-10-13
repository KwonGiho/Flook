package Manager;

import java.util.ArrayList;
import java.util.LinkedList;

import DAO.CartDAO;
import VO.CartVO;
import ViewDAO.CartViewDAO;
import ViewVO.CartViewVO;

public class CartManager {
	private CartViewDAO cartViewDAO;
	private CartDAO cartDAO;
	
	public CartManager(){
		cartViewDAO = CartViewDAO.getInstance();
		cartDAO=CartDAO.getInstance();
	}
	
	public ArrayList<CartViewVO> searchUserCode(String userCode) {
		return cartViewDAO.searchCart(userCode);
	}
	public int insertCart(String userCode,String ingredientCode)
	{ 
		return cartDAO.insertCart(userCode, ingredientCode);
	}
	public int deleteCart(String userCode,String ingredientCode)
	{
		return cartDAO.deleteCart(userCode, ingredientCode);
	} 
	public CartVO searchCart(String userCode,String ingredientCode)
	{
		return cartDAO.searchCart(userCode, ingredientCode);//�Ⱦ��� ������ �ϴ� ����
	}
	public LinkedList<CartVO> searchCartList(String userCode)
	{
		return cartDAO.searchCartList(userCode);
	}
	
	public static void main(String[]args)
	{
		System.out.println("Ȯ��");
		CartManager man = new CartManager();
		
		ArrayList<CartViewVO> array = man.searchUserCode("UT1438995413471");
		
		for(int i=0; i<array.size(); i++)
		{
			System.out.println(array.get(i).getCartCode());
		}
	}
}
