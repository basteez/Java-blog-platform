package it.basteez.jbp.view;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;


import it.basteez.jbp.business.UserBeanLocal;
import it.basteez.jbp.data.User;
import it.basteez.jbp.utils.Utils;

@ManagedBean(name="login")
@RequestScoped
public class LoginBean {
	
	
	@EJB
	private UserBeanLocal userBusiness;
	
	private User user;
	
	public LoginBean() {
		user = new User();
	}

	public UserBeanLocal getUserBusiness() {
		return userBusiness;
	}

	public User getAccount() {
		return user;
	}

	public void setAccountBusiness(UserBeanLocal accountBusiness) {
		this.userBusiness = accountBusiness;
	}

	public void setAccount(User user) {
		this.user = user;
	}

	public void login() {
		String passwordHash = new String();
		String username = getAccount().getUsername();
		try {
			passwordHash = Utils.getMd5Hash(getAccount().getPassword());
			if(userBusiness.findUserByLoginCredentials(username,passwordHash) != null) {
				//TODO: Add user to session and set redirect
				FacesContext.getCurrentInstance().getExternalContext().redirect("login-success.xhtml");
				
			} else FacesContext.getCurrentInstance().addMessage("login-error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Username not found or password does not match"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
