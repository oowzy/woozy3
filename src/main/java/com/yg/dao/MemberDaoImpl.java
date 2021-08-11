package com.yg.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.yg.dto.MemberDto;

public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int loginCheck(String id, String pw) {
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("id", id);
		map1.put("pw", pw);
		int result= sqlSession.selectOne("com.yg.mapper.memberMapper.loginCheck",map1);
		
		return result;		//1 로그인 성공 0 실패
	}
	
	@Override
	public int insert(MemberDto dto) {
		return sqlSession.insert("com.yg.mapper.memberMapper.insertMember",dto);
	}

	@Override
	public int updatePoint() {
		 return sqlSession.update("com.yg.mapper.memberMapper.checkPoint");
	}

}
