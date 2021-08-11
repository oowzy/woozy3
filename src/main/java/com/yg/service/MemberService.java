package com.yg.service;

import com.yg.dto.MemberDto;

public interface MemberService {
	boolean loginCheck(String id, String pw);
	boolean registerMember(MemberDto dto);
	 void test();    
	
}
