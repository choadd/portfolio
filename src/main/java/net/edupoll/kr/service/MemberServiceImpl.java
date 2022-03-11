package net.edupoll.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.MemberVO;
import net.edupoll.kr.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDAO memberdao;
	
	@Override
	public List<MemberVO> selectList() {
		return memberdao.selectList();
	}

	@Override
	public int insertOne(MemberVO vo) {
		return memberdao.insertOne(vo);
	}

	@Override
	public void delete(int no) {
		memberdao.delete(no);
	}

	@Override
	public void update(MemberVO vo) {
		memberdao.update(vo);
	}

	public String nickname(MemberVO vo){
		return memberdao.nickname(vo);
	};
	
}
