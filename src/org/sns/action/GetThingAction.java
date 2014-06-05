package org.sns.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.sns.model.Thing;
import org.sns.model.User;
import org.sns.service.ThingService;
import org.sns.service.UserService;
import org.sns.util.SessionManager;

/**
 * @author gejing gjblmdlm@sina.com
 * @version Creation Time：2014-5-27 上午1:57:26
 * 获取新鲜事
 */
public class GetThingAction implements Action{
	private List<Thing> list;
	private List<Thing> result;
	private ThingService thingService;
	private UserService userService;
	private short type;
//	private List<Thing> result;
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//判断是否在线
		if (SessionManager.isOnLine()) {
			User currentUser=SessionManager.getUser();
			list=thingService.getThing(currentUser);
			result=new ArrayList<Thing>();
			if (list.isEmpty()) {//如果为空
				return  Action.SUCCESS;
			}
	
			if(type==0){
				
				for(Thing t:list){
					if (t.getType()==0) {
						result.add(t);
					}
				}
			}else if(type==1){
				for(Thing t:list){
					if (t.getType()==1) {
						result.add(t);
					}
				}
			}else {
				for(Thing t:list){
					if (t.getType()==2) {
						result.add(t);
					}
				}
			}
	
			return Action.SUCCESS;
		}else {
			return Action.LOGIN;
		}
		
	
	}
	public ThingService getThingService() {
		return thingService;
	}
	public void setThingService(ThingService thingService) {
		this.thingService = thingService;
	}
	public List<Thing> getList() {
		return list;
	}
	public void setList(List<Thing> list) {
		this.list = list;
	}
	public short getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<Thing> getResult() {
		return result;
	}
	public void setResult(List<Thing> result) {
		this.result = result;
	}

}
