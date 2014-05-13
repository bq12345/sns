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
 * Mark entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mark", catalog = "sns")
public class Mark implements java.io.Serializable {

	// Fields

	private Integer markId;
	private User user;
	private Page page;

	// Constructors

	/** default constructor */
	public Mark() {
	}

	/** full constructor */
	public Mark(User user, Page page) {
		this.user = user;
		this.page = page;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "mark_id", unique = true, nullable = false)
	public Integer getMarkId() {
		return this.markId;
	}

	public void setMarkId(Integer markId) {
		this.markId = markId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "p_id")
	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}