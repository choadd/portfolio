package net.edupoll.kr.service;

import java.util.List;

import net.edupoll.kr.entity.MemberVO;

public interface AdminService {
	public String admin(MemberVO vo);

	public List memberList();

	public void deleteById(int no);
}
