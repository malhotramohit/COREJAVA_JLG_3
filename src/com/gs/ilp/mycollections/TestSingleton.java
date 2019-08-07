package com.gs.ilp.mycollections;

public class TestSingleton {
	public static void main(String[] args) {
		
		

		LeadDetailService leadDetailService1 = (LeadDetailService) ServiceFactory
				.getInstance(LeadDetailServiceImpl.class, Handler.UPTIME);

		LeadDetailService leadDetailService2 = (LeadDetailService) ServiceFactory
				.getInstance(LeadDetailOfflineServiceImpl.class, Handler.DOWNTIME);

		// Leads leads = (Leads) ServiceFactory.getInstance(Leads.class);

		System.out.println(leadDetailService1);
		System.out.println(leadDetailService2);

	}

}
