package com.yg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yg.dao.MemberDao;
import com.yg.dto.MemberDto;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;
	
	@Override
	public boolean loginCheck(String id, String pw) {
		int result= dao.loginCheck(id, pw);
		return result ==1;	//1이면 true 0인면 false
	}

	@Override
	public boolean registerMember(MemberDto dto) {
		int result = dao.insert(dto);
		return result==1;
		
	}

	@Override
	public void test() {
		int result = dao.updatePoint();
		System.out.println("실행댐");
	}
	
}
