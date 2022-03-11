package net.edupoll.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.MemberVO;
import net.edupoll.kr.repository.AdminDAO;
import net.edupoll.kr.repository.MemberDAO;

@Repository
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDao;
	
	@Override
	public String admin(MemberVO vo) {
		return adminDao.admin(vo);
	}

	@Override
	public List memberList() {
		return adminDao.memberList();
	}

	@Override
	public void deleteById(int no) {
		adminDao.deleteById(no);
	}
}
