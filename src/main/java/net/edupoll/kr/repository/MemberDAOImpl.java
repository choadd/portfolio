package net.edupoll.kr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.BoardVO;
import net.edupoll.kr.entity.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	SqlSession sqlsession;

	@Override
	public List<MemberVO> selectList() {
		return sqlsession.selectList("member.selectMemberList");
	}

	@Override
	public int insertOne(MemberVO vo) {
		return sqlsession.insert("member.joinMember", vo);
	}

	@Override
	public void delete(int no) {
		sqlsession.delete("member.deleteByIdMember");
	}

	@Override
	public void update(MemberVO vo) {
		sqlsession.update("member.update");
	}

	public String nickname(MemberVO vo) {
		return sqlsession.selectOne("member.loginNickname", vo);
	}

}
