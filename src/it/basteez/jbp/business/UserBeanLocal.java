package it.basteez.jbp.business;

import java.util.List;

import javax.ejb.Local;

import it.basteez.jbp.data.User;

@Local
public interface UserBeanLocal {
	//create remove update find
	public void createUser(User u);
	public void removeUser(Integer id);
	public void updateUser(User u);
	public User findUserByLoginCredentials(String username, String password);
	public List<User> findAll();
}
