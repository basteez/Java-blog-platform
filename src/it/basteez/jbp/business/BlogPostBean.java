package it.basteez.jbp.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.basteez.jbp.data.BlogPost;
import it.basteez.jbp.data.Comment;
import it.basteez.jbp.data.User;

@Stateless
public class BlogPostBean implements BlogPostBeanLocal {

	@PersistenceContext(unitName="jbpPersistence")
	EntityManager manager;
	
    public BlogPostBean() {

    }

	@Override
	public void createBlogPost(BlogPost bp) {
		manager.persist(bp);
	}

	@Override
	public void removeBlogPost(Integer id) {
		BlogPost bp = manager.find(BlogPost.class, id);
		manager.remove(bp);
	}

	@Override
	public void updateBlogPost(BlogPost bp) {
		manager.merge(bp);
	}

	@Override
	public BlogPost findBlogPostById(Integer id) {
		return manager.find(BlogPost.class, id);
	}

	@Override
	public List<BlogPost> findBlogPostByAuthor(User u) {
		Query q = manager.createQuery("SELECT bp FROM BlogPost bp WHERE bp.author_id = :authorId");
		q.setParameter("authorId", u.getId());
		List<BlogPost> results = q.getResultList();
		return results;
	}

	@Override
	public List<BlogPost> findAll() {
		Query q = manager.createQuery("SELECT bp FROM BlogPost bp");
		List<BlogPost> results = q.getResultList();
		return results;
	}

    
}
