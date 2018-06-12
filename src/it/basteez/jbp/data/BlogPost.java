package it.basteez.jbp.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BlogPost implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private User author;
	private String title;
	private String text;
	private Date date;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	public Integer getId() {
		return id;
	}
	
	@OneToOne
	@JoinColumn(name="author_id", nullable=false)
	public User getAuthor() {
		return author;
	}
	
	@Column(name="title", nullable=false)
	public String getTitle() {
		return title;
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
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
