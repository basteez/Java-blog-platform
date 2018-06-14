package it.basteez.jbp.business;

import java.util.List;

import javax.ejb.Local;

import it.basteez.jbp.data.Comment;
import it.basteez.jbp.data.User;

@Local
public interface CommentBeanLocal {
	public void createComment(Comment c);
	public void removeComment(Integer id);
	public void updateComment(Comment c);
	public Comment findCommentById(Integer id);
	public List<Comment> findCommentByAuthor(User u);
	public List<Comment> findAll();
}
