package net.edupoll.kr.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.edupoll.kr.entity.BoardVO;
import net.edupoll.kr.entity.PrevNext;
import net.edupoll.kr.entity.SearchKeyword;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	public List<BoardVO> selectList() {
		return sqlSession.selectList("board.selectAll");
	}

	public int insertOne(BoardVO vo) {
		return sqlSession.insert("board.insertOne", vo);
	}

	public void delete(int no) {
		sqlSession.delete("board.deleteById", no);
	}

	@Override
	public void update(BoardVO vo) {
		sqlSession.update("board.updateById", vo);
	}

	public BoardVO selectOne(int no) {
		return sqlSession.selectOne("board.selectOne", no);
	}

	public List<BoardVO> selectPageList(int pageStart) {
		return sqlSession.selectList("board.selectPage", pageStart);
	}

	@Override
	public int countBoardList() {
		return sqlSession.selectOne("board.countBoard");
	}

	@Override
	public PrevNext prevAndNext(int no) {
		return sqlSession.selectOne("board.prevAndNext",no);
	}

	@Override
	public List<BoardVO> searchByKeyword(SearchKeyword search) {
		return sqlSession.selectList("board.searchTitle",search);
	}

}
