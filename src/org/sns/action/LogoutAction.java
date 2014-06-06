package org.sns.action;

import org.sns.util.SessionManager;

/**
 * 退出的action
 * @author bq 
 */
public class LogoutAction implements Action {
	@Override
	public String execute() throws Exception {
		SessionManager.remove();
		return Action.SUCCESS;
	}
}
