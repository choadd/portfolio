package net.edupoll.kr.controller;

import java.util.UUID;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("authValue")
public class AuthController {

	@GetMapping("/auth")
	public String authHandle(Model model) {
		UUID uuid = UUID.randomUUID();
		String[] uuids = uuid.toString().split("-");

		model.addAttribute("authValue", uuids[0]);

		return "auth";
	}

	@GetMapping("/auth/pass")
	public String authCheck(@SessionAttribute String authValue, @RequestParam("userkey") String userkey, Model model,
			SessionStatus status) {
		status.setComplete();
		if (authValue.equals(userkey)) {
			return "authok";
		} else {
			return "redirect:/auth";
		}
	}

}
