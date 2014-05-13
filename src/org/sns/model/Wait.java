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
 * Wait entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wait", catalog = "sns")
public class Wait implements java.io.Serializable {

	// Fields

	private Integer waitId;
	private User userBySenderId;
	private User userByReceiverId;

	// Constructors

	/** default constructor */
	public Wait() {
	}

	/** full constructor */
	public Wait(User userBySenderId, User userByReceiverId) {
		this.userBySenderId = userBySenderId;
		this.userByReceiverId = userByReceiverId;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "wait_id", unique = true, nullable = false)
	public Integer getWaitId() {
		return this.waitId;
	}

	public void setWaitId(Integer waitId) {
		this.waitId = waitId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_id")
	public User getUserBySenderId() {
		return this.userBySenderId;
	}

	public void setUserBySenderId(User userBySenderId) {
		this.userBySenderId = userBySenderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver_id")
	public User getUserByReceiverId() {
		return this.userByReceiverId;
	}

	public void setUserByReceiverId(User userByReceiverId) {
		this.userByReceiverId = userByReceiverId;
	}

}