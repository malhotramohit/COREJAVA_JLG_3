package com.gs.ilp.mycollections;

public class LeadDetailServiceImpl implements LeadDetailService {

	private static LeadDetailServiceImpl intance = new LeadDetailServiceImpl();

	public static LeadDetailServiceImpl getInstance() {
		return intance;
	}

	private LeadDetailServiceImpl() {

	}
}
