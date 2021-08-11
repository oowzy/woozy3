package com.yg.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yg.dao.MemberDao;
import com.yg.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDaoTest {
	@Autowired
	private MemberDao dao;
	
	@Test
	public void testloginCheck() throws Exception {
		int result=dao.loginCheck("abc", "1234");
		System.out.println(result);
		result=dao.loginCheck("aaa", "1234");
		System.out.println(result);
	}

	@Test
	public void testinsert() throws Exception {
		int result=dao.insert(new MemberDto("id3","pw2","name2"));
		if(result==1) {
			System.out.println("회원가입성공");
		}
	}
	
	@Test
	public void testupdate() throws Exception {
		int result=dao.updatePoint();
	}
	
	
}
