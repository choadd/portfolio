package net.edupoll.kr.repository;

import java.util.List;

import net.edupoll.kr.entity.BoardVO;
import net.edupoll.kr.entity.PrevNext;
import net.edupoll.kr.entity.SearchKeyword;

public interface BoardDAO {

	public List<BoardVO> selectList();

	public int insertOne(BoardVO vo);

	public void delete(int no);
	
	public void update(BoardVO vo);

	public BoardVO selectOne(int no);

	public List<BoardVO> selectPageList(int pageStart);
	
	public int countBoardList();
	
	public PrevNext prevAndNext(int no);
	
	public List<BoardVO> searchByKeyword(SearchKeyword search);
}
