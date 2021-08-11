package com.yg.dao;

import com.yg.dto.MemberDto;

public interface MemberDao {
	int loginCheck(String id, String pw);
	int insert(MemberDto dto);
	int updatePoint();
}
