package com.gs.ilp.mycollections;

public class ServiceFactory {

	public static Object getInstance(Class clazz, String handlerType) {

		if ("LeadDetailServiceImpl".equals(clazz.getName())) {
			return LeadDetailServiceImpl.getInstance();
		} else if ("Leads".equals(clazz.getName())) {
			return new Leads();
		}
		return null;
	}

}
