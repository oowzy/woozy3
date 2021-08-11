package com.yg.test;

import java.sql.SQLIntegrityConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yg.dto.MemberDto;
import com.yg.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberServiceTest {
	@Autowired
	private MemberService service;
	
	@Test
	public void testloginCheckService() throws Exception {
		System.out.println(service.loginCheck("aaa", "1234"));
		System.out.println(service.loginCheck("aab", "1234"));
		
	}
	
	@Test
	public void testRegisterMemberService() throws Exception{
		System.out.println(service.registerMember(new MemberDto("IDtest","1234","이름")));
	
	}
}
