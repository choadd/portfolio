package net.edupoll.kr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.edupoll.kr.service.AdminService;
import net.edupoll.kr.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	//회원목록 조회
	@RequestMapping("")
	public String memberList(Model model) {
		model.addAttribute("list", adminService.memberList());
		return "/admin/admin";
	}
	
	//회원삭제
	@RequestMapping("/delete")
	public String deleteById(@RequestParam int no) {
		adminService.deleteById(no);
		return "redirect:/admin";
	}
	
	
}
