package com.example.catrionaspetitions;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CatrionaspetitionsApplication.class);
	}

	@GetMapping("/create")
	public String showCreatePetitionForm() {

		return "create-petition";
	}

	@PostMapping("/create")
	public String createPetition(@RequestParam String title, @RequestParam String content) {
		Petition petition = new Petition();
		petition.setTitle(title);
		petition.setContent(content);
		return "redirect:/";
	}


}
