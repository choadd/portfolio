package net.edupoll.kr.repository;

import java.util.List;

import net.edupoll.kr.entity.MemberVO;

public interface AdminDAO {
	public String admin(MemberVO vo);
	
	public List memberList();
	
	public void deleteById(int no);
}
