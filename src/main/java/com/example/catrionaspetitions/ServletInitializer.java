package com.example.catrionaspetitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")

public class ServletInitializer extends SpringBootServletInitializer {
	private final List<Petition> petitions = new ArrayList<>();

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CatrionaspetitionsApplication.class);
	}


	@GetMapping
	public String showAllPetitions(Model model) {
		model.addAttribute("petitions", petitions);
		return "all-petitions"; // The name of the Thymeleaf template to render
	}


	@GetMapping("/create")
	public String showCreatePetitionForm() {

		return "create-petition";
	}

	@PostMapping("/create")
	public String createPetition(@RequestParam String title, @RequestParam String content) {
		Petition petition = new Petition(title, content);
		petitions.add(petition);
		return "redirect:/";
	}

	@GetMapping("/search")
	public String searchPetitions() {

		return "search-petition";
	}


}
