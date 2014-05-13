package org.sns.util;

import org.sns.model.User;

import com.opensymphony.xwork2.ActionContext;

public class SessionManager {
	/**
	 * If a user is login
	 * @return boolean
	 */
	public static boolean isOnLine() {
		return null == getUser();
	}

	/**
	 * Remove user&key from session
	 */
	public static void remove() {
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().remove("key");
	}

	/**
	 * Put user to session
	 * @param u
	 */
	public static void add(User u) {
		ActionContext.getContext().getSession().put("user", u.getUsername());
		ActionContext.getContext().getSession().put("key", u.getUserId());
	}

	/**
	 * Get a user from session
	 * @return user
	 */
	public static User getUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}

	/**
	 * Get a key from session
	 * @return key
	 */
	public static int getKey() {
		return (Integer) ActionContext.getContext().getSession().get("key");
	}
}
