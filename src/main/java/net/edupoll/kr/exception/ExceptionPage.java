package net.edupoll.kr.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionPage {

	@ExceptionHandler(Exception.class)
	public String exceptionView(Exception e, Model model) {
		model.addAttribute("exception", e.getMessage());

		return "/exception/errorPage";
	}

}
