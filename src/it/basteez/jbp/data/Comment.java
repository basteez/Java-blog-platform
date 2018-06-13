package it.basteez.jbp.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private User author;
	private BlogPost blogPost;
	private String text;
	private Date date;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	public Integer getId() {
		return id;
	}
	
	@ManyToOne()
	@JoinColumn(name="author_id", nullable=false)
	public User getAuthor() {
		return author;
	}
	
	@OneToOne
	@JoinColumn(name="blog_post_id", nullable=false)
	public BlogPost getBlogPost() {
		return blogPost;
	}
	
	@Column(name="text", nullable=false)
	public String getText() {
		return text;
	}
	
	@Column(name="date", nullable=false)
	public Date getDate() {
		return date;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
	
	public void setBlogPost(BlogPost blogPost) {
		this.blogPost = blogPost;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
