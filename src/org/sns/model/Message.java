package org.sns.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "sns")
public class Message implements java.io.Serializable {

	// Fields

	private Integer msgId;
	private User userBySenderId;
	private User userByReceiverId;
	private String content;
	private Timestamp time;
	private Short read;
	private String sender;
	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(User userBySenderId, User userByReceiverId, String content,
			Timestamp time, Short read) {
		this.userBySenderId = userBySenderId;
		this.userByReceiverId = userByReceiverId;
		this.content = content;
		this.time = time;
		this.read = read;
	}
	public Message(User userBySenderId, User userByReceiverId, String content,
			Timestamp time) {
		this.userBySenderId = userBySenderId;
		this.userByReceiverId = userByReceiverId;
		this.content = content;
		this.time = time;
	}
	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "msg_id", unique = true, nullable = false)
	public Integer getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
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

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "has_read")
	public Short getRead() {
		return this.read;
	}

	public void setRead(Short read) {
		this.read = read;
	}
	@Column(name = "sender")
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
}