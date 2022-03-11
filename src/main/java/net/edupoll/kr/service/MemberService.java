package net.edupoll.kr.service;

import java.util.List;

import net.edupoll.kr.entity.MemberVO;

public interface MemberService {

	public List<MemberVO> selectList();

	public int insertOne(MemberVO vo);

	public void delete(int no);

	public void update(MemberVO vo);

	public String nickname(MemberVO vo);
}
