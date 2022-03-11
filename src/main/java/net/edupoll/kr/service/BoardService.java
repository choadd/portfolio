package net.edupoll.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.BoardVO;
import net.edupoll.kr.entity.PrevNext;
import net.edupoll.kr.entity.SearchKeyword;
import net.edupoll.kr.repository.BoardDAOImpl;

public interface BoardService {

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
