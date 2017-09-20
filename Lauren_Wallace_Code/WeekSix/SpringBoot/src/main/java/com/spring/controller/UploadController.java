package com.spring.controller;

//Needed for the controller
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//To handle any possible exceptions
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
	
	//This will save the uploaded file to this folder
	private static String uploadFolder = "";
	
	@GetMapping("/")
	public String index() {
		return "upload";
	}
	
	//@PostMapping is a new annotation since 4.3
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile, RedirectAttributes redirectAttributes) {
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			//Getting the file and saving it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFolder + file.getOriginalFilename());
			Files.write(path, bytes);
		}
	}

}
