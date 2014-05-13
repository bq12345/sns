package org.sns.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Thing entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "thing", catalog = "sns")
public class Thing implements java.io.Serializable,Comparable<Thing> {

	// Fields

	private Integer thingId;
	private User user;
	private String content;
	private Timestamp time;
	private Integer commentNum;
	private Integer shareNum;
	private Blob image;
	private Short type;
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public Thing() {
	}

	/** full constructor */
	public Thing(User user, String content, Timestamp time, Integer commentNum,
			Integer shareNum, Blob image, Short type, Set<Comment> comments) {
		this.user = user;
		this.content = content;
		this.time = time;
		this.commentNum = commentNum;
		this.shareNum = shareNum;
		this.image = image;
		this.type = type;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "thing_id", unique = true, nullable = false)
	public Integer getThingId() {
		return this.thingId;
	}

	public void setThingId(Integer thingId) {
		this.thingId = thingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "send_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "content", length = 65535)
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

	@Column(name = "comment_num")
	public Integer getCommentNum() {
		return this.commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	@Column(name = "share_num")
	public Integer getShareNum() {
		return this.shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	@Column(name = "image")
	public Blob getImage() {
		return this.image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Column(name = "type")
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "thing")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int compareTo(Thing t) {
		return (int)(this.getTime().getTime()-t.getTime().getTime());
	}

}