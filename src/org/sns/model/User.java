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
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Page> pages = new HashSet<Page>(0);
	private Set<Message> messagesForSenderId = new HashSet<Message>(0);
	private Set<Thing> things = new HashSet<Thing>(0);
	private Set<Wait> waitsForReceiverId = new HashSet<Wait>(0);
	private Set<Mark> marks = new HashSet<Mark>(0);
	private Set<Friend> friendsForUserId = new HashSet<Friend>(0);
	private Set<Friend> friendsForOtherId = new HashSet<Friend>(0);
	private Set<Message> messagesForReceiverId = new HashSet<Message>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

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
		this.comments = comments;
		this.pages = pages;
		this.messagesForSenderId = messagesForSenderId;
		this.things = things;
		this.waitsForReceiverId = waitsForReceiverId;
		this.marks = marks;
		this.friendsForUserId = friendsForUserId;
		this.friendsForOtherId = friendsForOtherId;
		this.messagesForReceiverId = messagesForReceiverId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex")
	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "qq", length = 45)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "able")
	public Short getAble() {
		return this.able;
	}

	public void setAble(Short able) {
		this.able = able;
	}

	@Column(name = "state")
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	@Column(name = "image")
	public Blob getImage() {
		return this.image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userBySenderId")
	public Set<Wait> getWaitsForSenderId() {
		return this.waitsForSenderId;
	}

	public void setWaitsForSenderId(Set<Wait> waitsForSenderId) {
		this.waitsForSenderId = waitsForSenderId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Page> getPages() {
		return this.pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userBySenderId")
	public Set<Message> getMessagesForSenderId() {
		return this.messagesForSenderId;
	}

	public void setMessagesForSenderId(Set<Message> messagesForSenderId) {
		this.messagesForSenderId = messagesForSenderId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Thing> getThings() {
		return this.things;
	}

	public void setThings(Set<Thing> things) {
		this.things = things;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByReceiverId")
	public Set<Wait> getWaitsForReceiverId() {
		return this.waitsForReceiverId;
	}

	public void setWaitsForReceiverId(Set<Wait> waitsForReceiverId) {
		this.waitsForReceiverId = waitsForReceiverId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Mark> getMarks() {
		return this.marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUserId")
	public Set<Friend> getFriendsForUserId() {
		return this.friendsForUserId;
	}

	public void setFriendsForUserId(Set<Friend> friendsForUserId) {
		this.friendsForUserId = friendsForUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByOtherId")
	public Set<Friend> getFriendsForOtherId() {
		return this.friendsForOtherId;
	}

	public void setFriendsForOtherId(Set<Friend> friendsForOtherId) {
		this.friendsForOtherId = friendsForOtherId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByReceiverId")
	public Set<Message> getMessagesForReceiverId() {
		return this.messagesForReceiverId;
	}

	public void setMessagesForReceiverId(Set<Message> messagesForReceiverId) {
		this.messagesForReceiverId = messagesForReceiverId;
	}

}