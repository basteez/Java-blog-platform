package it.basteez.jbp.view;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import it.basteez.jbp.business.UserBeanLocal;
import it.basteez.jbp.data.User;

@ManagedBean(name="user_manager")
@RequestScoped
public class UserManagedBean {

	@EJB
	private UserBeanLocal userBusiness;
	
	private User user;
	
	public UserManagedBean() {
		user = new User();
	}

	public UserBeanLocal getUserBusiness() {
		return userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUserBusiness(UserBeanLocal userBusiness) {
		this.userBusiness = userBusiness;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getUsersList(){
		return userBusiness.findAll();
	}
	
	
}
