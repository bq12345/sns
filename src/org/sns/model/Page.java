package org.sns.model;

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
 * Page entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "page", catalog = "sns")
public class Page implements java.io.Serializable {

	// Fields

	private Integer pageId;
	private User user;
	private String name;
	private String detail;
	private Set<Mark> marks = new HashSet<Mark>(0);

	// Constructors

	/** default constructor */
	public Page() {
	}

	/** full constructor */
	public Page(User user, String name, String detail, Set<Mark> marks) {
		this.user = user;
		this.name = name;
		this.detail = detail;
		this.marks = marks;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "page_id", unique = true, nullable = false)
	public Integer getPageId() {
		return this.pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "detail")
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "page")
	public Set<Mark> getMarks() {
		return this.marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

}