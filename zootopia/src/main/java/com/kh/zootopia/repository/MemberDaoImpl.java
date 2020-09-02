package com.kh.zootopia.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.zootopia.entity.CertDto;
import com.kh.zootopia.entity.MemberDto;



@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession sqlSession;
	

	


	
	//비밀 번호 찾기
	@Override
	public int searchpw(String member_id, String email) {
		Map<String, Object> map = new HashMap<>();
		map.put("member_id", member_id);
		map.put("email", email);
		
		return sqlSession.selectOne("member.findpw", map);
	}


	// 비밀번호 변경
	@Override
	public void changepw(String member_id) {
		sqlSession.update("member.changepw", member_id);
		
	}

	
	
	
	/////////////////////////////////////////
// 아이디 찾기 
	@Override
	public String searchid(String member_name, String email) {
		Map<String, Object> map = new HashMap<>();
		map.put("member_name", member_name);
		map.put("email", email);

		return sqlSession.selectOne("member.findid",map);
	}

	// 아이디 찾기 랜덤 번호 추가
	@Override
	public void insert(CertDto certDto) {
		
		sqlSession.insert("member.insertCert",certDto);
	}
	@Override
	public boolean validate(CertDto certDto) {
		
		CertDto result = sqlSession.selectOne("member.validate",certDto);
		if(result !=null) {
			sqlSession.delete("member.remove",result);
		}
		
		return result !=null;

	}

	@Override
	public String CertId(String secret) {
		
		return sqlSession.selectOne("member.certId",secret);
	}

	
	////////////////////////////////
	
	
	
	
}