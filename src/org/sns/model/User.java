package org.sns.model;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "sns")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;

	private String username;
	private String password;
	private Short sex;
	private String phone;
	private String qq;
	private String email;
	private Short able;
	private Short state;
	private Blob image;
	private Set<Wait> waitsForSenderId = new HashSet<Wait>(0);
	private Set<Page> pages = new HashSet<Page>(0);
	private Set<Message> messagesForSenderId = new HashSet<Message>(0);
	private Set<Thing> things = new HashSet<Thing>(0);
	private Set<Wait> waitsForReceiverId = new HashSet<Wait>(0);
	private Set<Mark> marks = new HashSet<Mark>(0);
	private Set<Friend> friendsForUserId = new HashSet<Friend>(0);
	private Set<Friend> friendsForOtherId = new HashSet<Friend>(0);
	private Set<Message> messagesForReceiverId = new HashSet<Message>(0);

	/** default constructor */
	public User() {
	}

	// Constructors

	/** full constructor */
	public User(String username, String password, Short sex, String phone,
			String qq, String email, Short able, Short state, Blob image,
			Set<Wait> waitsForSenderId, Set<Comment> comments, Set<Page> pages,
			Set<Message> messagesForSenderId, Set<Thing> things,
			Set<Wait> waitsForReceiverId, Set<Mark> marks,
			Set<Friend> friendsForUserId, Set<Friend> friendsForOtherId,
			Set<Message> messagesForReceiverId) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.qq = qq;
		this.email = email;
		this.able = able;
		this.state = state;
		this.image = image;
		this.waitsForSenderId = waitsForSenderId;
		this.pages = pages;
		this.messagesForSenderId = messagesForSenderId;
		this.things = things;
		this.waitsForReceiverId = waitsForReceiverId;
		this.marks = marks;
		this.friendsForUserId = friendsForUserId;
		this.friendsForOtherId = friendsForOtherId;
		this.messagesForReceiverId = messagesForReceiverId;
	}

	@Column(name = "able")
	public Short getAble() {
		return this.able;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userByOtherId")
	public Set<Friend> getFriendsForOtherId() {
		return this.friendsForOtherId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userByUserId")
	public Set<Friend> getFriendsForUserId() {
		return this.friendsForUserId;
	}

	@Column(name = "image")
	public Blob getImage() {
		return this.image;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Mark> getMarks() {
		return this.marks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userByReceiverId")
	public Set<Message> getMessagesForReceiverId() {
		return this.messagesForReceiverId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userBySenderId")
	public Set<Message> getMessagesForSenderId() {
		return this.messagesForSenderId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Page> getPages() {
		return this.pages;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	@Column(name = "qq", length = 45)
	public String getQq() {
		return this.qq;
	}

	@Column(name = "sex")
	public Short getSex() {
		return this.sex;
	}

	@Column(name = "state")
	public Short getState() {
		return this.state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Thing> getThings() {
		return this.things;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userByReceiverId")
	public Set<Wait> getWaitsForReceiverId() {
		return this.waitsForReceiverId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userBySenderId")
	public Set<Wait> getWaitsForSenderId() {
		return this.waitsForSenderId;
	}

	public void setAble(Short able) {
		this.able = able;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFriendsForOtherId(Set<Friend> friendsForOtherId) {
		this.friendsForOtherId = friendsForOtherId;
	}

	public void setFriendsForUserId(Set<Friend> friendsForUserId) {
		this.friendsForUserId = friendsForUserId;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	public void setMessagesForReceiverId(Set<Message> messagesForReceiverId) {
		this.messagesForReceiverId = messagesForReceiverId;
	}

	public void setMessagesForSenderId(Set<Message> messagesForSenderId) {
		this.messagesForSenderId = messagesForSenderId;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public void setThings(Set<Thing> things) {
		this.things = things;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setWaitsForReceiverId(Set<Wait> waitsForReceiverId) {
		this.waitsForReceiverId = waitsForReceiverId;
	}

	public void setWaitsForSenderId(Set<Wait> waitsForSenderId) {
		this.waitsForSenderId = waitsForSenderId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}

}