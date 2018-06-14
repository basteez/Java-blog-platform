package it.basteez.jbp.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.basteez.jbp.data.Comment;
import it.basteez.jbp.data.User;

@Stateless
public class CommentBean implements CommentBeanLocal {

	@PersistenceContext(unitName="jbpPersistence")
	EntityManager manager;
	
    public CommentBean() {
    }

	@Override
	public void createComment(Comment c) {
		manager.persist(c);
	}

	@Override
	public void removeComment(Integer id) {
		Comment c = manager.find(Comment.class, id);
		manager.remove(c);
	}

	@Override
	public void updateComment(Comment c) {
		manager.merge(c);
	}

	@Override
	public Comment findCommentById(Integer id) {
		return manager.find(Comment.class, id);
	}

	@Override
	public List<Comment> findCommentByAuthor(User u) {
		Query q = manager.createQuery("SELECT c FROM Comment c WHERE c.author_id = :author_id");
		q.setParameter("author_id", u.getId());
		List<Comment> results = q.getResultList();
		return results;
	}

	@Override
	public List<Comment> findAll() {
		Query q = manager.createQuery("SELECT c FROM Comment c");
		List<Comment> results = q.getResultList();
		return results;
	}

}
