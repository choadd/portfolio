package net.edupoll.kr.controller.file;


import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//@Controller
public class WithFileController {

	@RequestMapping("/storage/insert")
	public void test() {

	}

	@RequestMapping("/storage/insertOk")
//	@RequestBody(required = false) String body
	public void storage(@RequestParam String title, @RequestParam MultipartFile attach) throws InterruptedException ,Exception{
		System.out.println("title ? " + title);
		System.out.println("contentType" + attach.getContentType());
		System.out.println("fileName" + attach.getOriginalFilename());

		File uploadDir = new File("d:\\upload");
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		File saveFile = new File(uploadDir, attach.getOriginalFilename());
		attach.transferTo(saveFile);

	}

}
