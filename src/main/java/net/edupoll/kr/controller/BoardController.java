package net.edupoll.kr.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.edupoll.kr.entity.BoardVO;
import net.edupoll.kr.entity.MemberVO;
import net.edupoll.kr.entity.SearchKeyword;
import net.edupoll.kr.service.AdminService;
import net.edupoll.kr.service.BoardService;
import net.edupoll.kr.service.MemberService;

@Controller
public class BoardController {

	@Resource(name = "uploadPath")
	String uploadPath;
	
	@Autowired
	BoardService boardService;

	@Autowired
	MemberService memberService;

	@Autowired
	AdminService AdminService;

	//키워드로 검색시에 값들 띄움
	@RequestMapping("/test")
	public String deleteOne(@ModelAttribute SearchKeyword search,Model model) {
		System.out.println(boardService.searchByKeyword(search));
		model.addAttribute("test",boardService.searchByKeyword(search));
		return "";
	}
	
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(required = false) String pageStart) {

		if (pageStart == null) {
			pageStart = "0";
		}
		// 페이징 처리를 위해 첫페이지번호 바인딩 + 목록조회
		model.addAttribute("list", boardService.selectPageList(Integer.parseInt(pageStart)));

		// 게시글 등록된 갯수
		model.addAttribute("boardCount", boardService.countBoardList());

		// 다음 페이지 이동
		return "/board/home";
	}

	// read 전체 글쓴목록 보여주기
//	@RequestMapping("/list")
//	public String list(Model model) {
//		model.addAttribute("list", boardService.selectList());
//		return "/board/home";
//	}

	// 세션에 닉네임 저장하기
	@PostMapping("/list")
	public String join(HttpSession session, @ModelAttribute MemberVO vo, Model model) {

		if (!AdminService.admin(vo).equals("admin")) {
			// 세션에 값 설정
			session.setAttribute("loginName", memberService.nickname(vo));
		} else {
			session.setAttribute("admin", memberService.nickname(vo));
		}
		// 조회된 유저 이름
		System.out.println(memberService.nickname(vo));
		return "redirect:/list";
	}

	// 업데이트시 필요 메서드 no값 바인딩
	@RequestMapping("/update")
	public String updateOne(@RequestParam("no") int no, Model model) {
		model.addAttribute("no", no);
		return "/board/update";
	}

	// 업데이트 후
	@RequestMapping("/updateClear")
	public String updateOne(@ModelAttribute BoardVO vo) {
		boardService.update(vo);
		System.out.println(vo);
		return "redirect:/list";
	}

	// 글번호로 상세보기
	@RequestMapping("/detail")
	public String datail(@RequestParam int no, Model model) {
		model.addAttribute("detail", boardService.selectOne(no));
		
		//상세 보기에 prev, next 만들어줌
		model.addAttribute("prevNext",boardService.prevAndNext(no));
		return "/board/detail";
	}

	// update view보여줌
	@RequestMapping("/add")
	public String insert() {
		return "/board/add";
	}

	// insert 게시글 추가할때 실행할 메서드 + 파일 업로드
	@PostMapping("/add")
	public String insertOK(@ModelAttribute BoardVO vo,ArrayList<MultipartFile> file) throws Exception {
		
		File upload = new File(uploadPath);
		
		if(!upload.exists()) {
			upload.mkdirs();
		}
		
		for (MultipartFile multipartFile : file) {
			File savefile = new File(uploadPath, UUID.randomUUID().toString()+"_");
			multipartFile.transferTo(savefile);
		}
		
		boardService.insertOne(vo);
		return "redirect:/list";
	}
	
	// delete 게시글 삭제할때 실행할 메서드
	@RequestMapping("/delete")
	public String deleteOne(@RequestParam int no) {
		boardService.delete(no);
		return "redirect:/list";
	}
	
}
