package org.sns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "friend", catalog = "sns")
public class Friend implements java.io.Serializable {

	// Fields

	private Integer friendId;
	private User userByUserId;
	private User userByOtherId;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** full constructor */
	public Friend(User userByUserId, User userByOtherId) {
		this.userByUserId = userByUserId;
		this.userByOtherId = userByOtherId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "friend_id", unique = true, nullable = false)
	public Integer getFriendId() {
		return this.friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUserByUserId() {
		return this.userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "other_id")
	public User getUserByOtherId() {
		return this.userByOtherId;
	}

	public void setUserByOtherId(User userByOtherId) {
		this.userByOtherId = userByOtherId;
	}

}