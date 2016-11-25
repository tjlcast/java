package bupt.tjlcast.service;

import bupt.tjlcast.dao.UserDao;
import bupt.tjlcast.entity.User;

public class UserService {
	UserDao ud = new UserDao() ;
	
	public User login(User user) {
		return ud.login(user) ;
	}
	
	public void register(User user) {
		ud.register(user);
	}
}
