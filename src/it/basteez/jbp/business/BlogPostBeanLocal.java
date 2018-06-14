package it.basteez.jbp.business;

import java.util.List;

import javax.ejb.Local;

import it.basteez.jbp.data.BlogPost;
import it.basteez.jbp.data.User;

@Local
public interface BlogPostBeanLocal {
	public void createBlogPost(BlogPost bp);
	public void removeBlogPost(Integer id);
	public void updateBlogPost(BlogPost bp);
	public BlogPost findBlogPostById(Integer id);
	public List<BlogPost> findBlogPostByAuthor(User u);
	public List<BlogPost> findAll();
}
