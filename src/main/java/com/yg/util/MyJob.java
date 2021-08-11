package com.yg.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.yg.dao.MemberDao;
import com.yg.service.MemberService;
import com.yg.service.MemberServiceImpl;

public class MyJob implements Job {
	@Autowired
	MemberDao dao;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException{
		
		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		MemberService service = ctx.getBean(MemberServiceImpl.class);
		
		int result = dao.updatePoint();
			System.out.println("몇명에게 +1점 주었스비다");
	}
}
