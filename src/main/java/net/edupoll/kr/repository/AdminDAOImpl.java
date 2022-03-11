package net.edupoll.kr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	SqlSession sqlsession;
	
	@Override
	public String admin(MemberVO vo) {
		return sqlsession.selectOne("admin.admin", vo);
	}

	@Override
	public List memberList() {
		return sqlsession.selectList("admin.memberList");
	}

	@Override
	public void deleteById(int no) {
		sqlsession.delete("admin.deleteById",no);
	}

}
