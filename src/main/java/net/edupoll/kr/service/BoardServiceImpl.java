package net.edupoll.kr.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edupoll.kr.entity.BoardVO;
import net.edupoll.kr.entity.PrevNext;
import net.edupoll.kr.entity.SearchKeyword;
import net.edupoll.kr.repository.BoardDAO;
import net.edupoll.kr.repository.BoardDAOImpl;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> selectList() {
		return boardDAO.selectList();
	}

	@Override
	public int insertOne(BoardVO vo) {
		return boardDAO.insertOne(vo);
	}

	public void delete(int no) {
		boardDAO.delete(no);
	}

	@Override
	public void update(BoardVO vo) {
		boardDAO.update(vo);
	}
	

	public BoardVO selectOne(int no) {
		return boardDAO.selectOne(no);
	}

	@Override
	public List<BoardVO> selectPageList(int pageStart) {
		
		return boardDAO.selectPageList(pageStart);
	}

	@Override
	public int countBoardList() {
		return boardDAO.countBoardList();
	}

	@Override
	public PrevNext prevAndNext(int no) {
		return boardDAO.prevAndNext(no);
	}

	@Override
	public List<BoardVO> searchByKeyword(SearchKeyword search) {
		return boardDAO.searchByKeyword(search);
	}
	
	
	
}
