package net.edupoll.kr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.edupoll.kr.entity.MemberVO;
import net.edupoll.kr.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	// 로그인 창으로이동
	@RequestMapping("/login")
	public String login() {
		return "/member/login";
	}

	//회원 가입창으로 이동
	@GetMapping("/join")
	public String join() {
		return "/member/join";
	}
	
	
	// 회원정보를 받아서 저장
	@PostMapping("/joinData")
	public String loginOK(@ModelAttribute MemberVO vo, Model model) {
		memberService.insertOne(vo);
		return "redirect:/list";
	}

	// 로그 아웃시 세션에 있는 값 제거
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/list";
	}
	
}
