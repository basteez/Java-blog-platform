package it.basteez.jbp.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String avatarLink;
	private String email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	public Integer getId() {
		return id;
	}
	
	@Column(name="username", nullable=false)
	public String getUsername() {
		return username;
	}
	
	@Column(name="password", nullable=false)
	public String getPassword() {
		return password;
	}
	
	@Column(name="first_name", nullable=false)
	public String getFirstName() {
		return firstName;
	}
	
	@Column(name="last_name", nullable=false)
	public String getLastName() {
		return lastName;
	}
	
	@Column(name="avatar_link")
	public String getAvatarLink() {
		return avatarLink;
	}
	
	@Column(name="email", nullable=false)
	public String getEmail() {
		return email;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAvatarLink(String avatarLink) {
		this.avatarLink = avatarLink;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
