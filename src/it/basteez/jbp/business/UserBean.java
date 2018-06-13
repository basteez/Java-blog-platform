package it.basteez.jbp.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.basteez.jbp.data.User;

@Stateless
public class UserBean implements UserBeanLocal {

	@PersistenceContext(name="jbpPersistence")
	EntityManager manager;
	
    public UserBean() {

    }

	@Override
	public void createUser(User u) {
		manager.persist(u);
	}

	@Override
	public void removeUser(Integer id) {
		User u = manager.find(User.class, id);
		manager.remove(u);
	}

	@Override
	public void updateUser(User u) {
		manager.merge(u);
	}

	@Override
	public User findUserByLoginCredentials(String username, String password) {
		Query q = manager.createQuery("SELECT  u FROM User u WHERE u.username = :username AND u.password = :password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		List<User> results = (List<User>) q.getResultList();
		if(!results.isEmpty()) {
			return (User) results.get(0);
		} 
		else return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

}
