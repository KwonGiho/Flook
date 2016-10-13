package Manager;

import DAO.UserDAO;
import VO.UserVO;

public class JoinManager {
	private UserDAO userDAO;
	public JoinManager(){
		this.userDAO = UserDAO.getInstance();
	}
	public byte joinMember(UserVO userVO) {
		this.userDAO = UserDAO.getInstance();/*����������*/
		return (byte)userDAO.insertUser(userVO);
		
	}
	public byte joinMember(String userName,String userImage,String userEmail,String userPassword,String userGender,String userBirthday){
		/*���� Ʋ������ ���� �������� �ݿ���.*/
		return (byte)userDAO.insertUser(userName, userImage, userEmail, userPassword, userGender, userBirthday);
		
	}
}