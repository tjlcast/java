package bupt.tjlcast.dao;

import bupt.tjlcast.entity.User;

public class UserDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * login
	 * @param user
	 * @return
	 */
	public User login(User user) {
		if ("tjl".equals(user.getName())) {
			return user ;
		}
		return null ;	
	}
	
	/**
	 * @param user
	 */
	public void register (User user) {
		System.out.println(user.getName());
		System.out.println(user.getPwd());
	}

}
