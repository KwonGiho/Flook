package ViewDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connection.DBConnection;
import ViewVO.CartViewVO;


/**
 * ����ڰ� �ٶ󺸴� �������� �ۼ��Ǿ���.
 * ������ ������ �ݿ� �ȵ� Ŭ������.
 * @author GHKwon
 *
 */
public class CartViewDAO {
	private static final CartViewDAO cartViewDAO;
	private DBConnection dbConnection;
	
	static {
		cartViewDAO = new CartViewDAO();
		
	}
	private CartViewDAO() {
		this(DBConnection.getInstance());
	}

	private CartViewDAO(DBConnection dbConnection) {
		super();
		this.dbConnection = dbConnection;
	}
	public static CartViewDAO getInstance() {
		return cartViewDAO;
	}
	
	public ArrayList<CartViewVO> searchCart(String userCode)
	{
		CartViewVO cartViewVO = null;
		PreparedStatement pstmt = null;
		ArrayList<CartViewVO> cartArray = null;
		try {
			cartArray = new ArrayList<CartViewVO>();
			String sql = "select * from cart_view where user_code=?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, userCode);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				String cartCode1 = res.getString("cart_code");
				String completeImage1 = res.getString("complete_image");
				String ingredientCode1 = res.getString("ingredient_code");
				String userCode1 = res.getString("user_code");
				String recipeCode1 = res.getString("recipe_code");
				String recipeName1 = res.getString("recipe_name");
				String ingredientName1 =res.getString("ingredient_name");
				int ingredientAmount1 = res.getInt("ingredient_amount");
				String ingredientUnitCode1 = res.getString("ingredient_unit_code");
				String ingredientUnitName1 = res.getString("ingredient_unit_name");
				
				cartViewVO = new CartViewVO(cartCode1, completeImage1, ingredientCode1, userCode1, recipeCode1, recipeName1,
						ingredientName1, ingredientAmount1, ingredientUnitCode1, ingredientUnitName1);
				cartArray.add(cartViewVO);
			}
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch( Exception ex ) {
				ex.printStackTrace();
			}
		}
		return cartArray;
	}
	/**
	 * ���� �������� ���� ��ᰡ �߰��� �� �ֱ� ������ ��ȯ���� CartViewVO[]�̴�.
	 * @param ingredientCode ����ڵ�.
	 * @return ��ٱ��Ͽ� ���������� ���ԵǾ��ִ� ������ �ڵ�.
	 */
	/*public CartViewVO[] searchIngredientCode(String ingredientCode) {
		ArrayList<CartViewVO> cartViewVO = new ArrayList<CartViewVO>();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from cart_view where ingredient_code=?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, ingredientCode);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				cartViewVO.add(new CartViewVO(res.getString("cart_code"),res.getString("ingredient_code"),res.getString("user_code"),res.getString("recipe_code"),res.getString("recipe_name"),res.getString("ingredient_name"),res.getInt("ingredient_number"),res.getString("ingredient_unit")));
			}
			return cartViewVO.toArray(new CartViewVO[cartViewVO.size()]);
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch( Exception ex ) {
				ex.printStackTrace();
			}
		}
		return null;
	}*/
	
	/**
	 * ���� �Ѹ��� ���� ��ٱ��ϸ� ������ �����Ƿ�, � ��ٱ��� ǰ����� ������ �ִ��� �˾ƺ��� ���� �޼ҵ�.
	 * @param userCode ȸ�� �ĺ��ڵ�.
	 * @return ȸ���� ������ �ִ� īƮ ������.
	 */
	/*public LinkedList<CartViewVO> searchUserCode(String userCode) {
		LinkedList<CartViewVO> cartViewVO = new LinkedList<CartViewVO>();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from cart_view where user_code=?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, userCode);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				cartViewVO.add(new CartViewVO(res.getString("cart_code"),res.getString("ingredient_code"),res.getString("user_code"),res.getString("recipe_code"),res.getString("recipe_name"),res.getString("ingredient_name"),res.getInt("ingredient_number"),res.getString("ingredient_unit")));
			}
			return cartViewVO;
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch( Exception ex ) {
				ex.printStackTrace();
			}
		}
		return null;
	}*/
	/**
	 * �Ѱ����� �����Ǵ� ���������� ��ٱ��� ǰ����� ���� �� �ִ�.
	 * �׷��Ƿ�, �߰��Ǿ��ִ� �Ѱ��Ƿ����� �ĺ��ڵ带 �̿��Ͽ� ��ٱ��Ͽ�
	 * ������ �ĺ��ڵ忡 �ش��ϴ� ��ٱ��� ��ϵ��� ��ȯ���ش�.
	 * @param recipeCode
	 * @return
	 */
	/*public CartViewVO[] searchRecipeCode(String recipeCode) {
		ArrayList<CartViewVO> cartViewVO = new ArrayList<CartViewVO>();
		PreparedStatement pstmt = null;
		try {
			String sql = "select * from cart_view where recipe_code=?";
			pstmt = dbConnection.getConn().prepareStatement(sql);
			pstmt.setString(1, recipeCode);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				cartViewVO.add(new CartViewVO(res.getString("cart_code"),res.getString("ingredient_code"),res.getString("user_code"),res.getString("recipe_code"),res.getString("recipe_name"),res.getString("ingredient_name"),res.getInt("ingredient_number"),res.getString("ingredient_unit")));
			}
			return cartViewVO.toArray(new CartViewVO[cartViewVO.size()]);
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch( Exception ex ) {
				ex.printStackTrace();
			}
		}
		return null;		
		
	}*/


	public static void main(String[]args)
	{
		System.out.println("Ȯ��");
		CartViewDAO cart = CartViewDAO.getInstance();
		
		ArrayList<CartViewVO> array = cart.searchCart("UT1438995413471");
		for(int i=0; i<array.size(); i++)
		{
			System.out.println(array.get(i).getCartCode());
		}
	}
}
