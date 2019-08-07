package com.gs.ilp.mycollections;

public class LeadDetailOfflineServiceImpl implements LeadDetailService {
	private static LeadDetailOfflineServiceImpl intance = new LeadDetailOfflineServiceImpl();

	public static LeadDetailOfflineServiceImpl getInstance() {
		return intance;
	}

	private LeadDetailOfflineServiceImpl() {

	}
}
