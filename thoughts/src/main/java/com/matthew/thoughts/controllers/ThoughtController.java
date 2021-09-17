package com.matthew.thoughts.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.thoughts.models.Thought;
import com.matthew.thoughts.models.User;
import com.matthew.thoughts.services.ThoughtService;
import com.matthew.thoughts.services.UserService;

@Controller
@RequestMapping("/thought")
public class ThoughtController {
	@Autowired
	private UserService uService;
	@Autowired
	private ThoughtService tService;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, @ModelAttribute("thought") Thought thought, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User loggedInUser = this.uService.findOneUser(userId);
		model.addAttribute("user", loggedInUser);
		model.addAttribute("allThoughts", this.tService.allThoughts());
		return "index.jsp";
	}
	
	@GetMapping("/dashboard/high")
	public String sortedDashboard(Model model, @ModelAttribute("thought") Thought thought, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User loggedInUser = this.uService.findOneUser(userId);
		model.addAttribute("user", loggedInUser);
		model.addAttribute("allThoughts", this.tService.getAllThoughtsSorted());
		return "index.jsp";
	}
	
	
	@PostMapping("/newThought")
	public String postThought(@Valid @ModelAttribute("thought") Thought thought, BindingResult result, HttpSession session, Model model) {
		Long userId = (Long)session.getAttribute("user_id");
		User loggedInUser = this.uService.findOneUser(userId);
		if(result.hasErrors()) {
			model.addAttribute("user", loggedInUser);
			return "index.jsp";
		}
		thought.setAuthor(loggedInUser);
		thought.setNumOfLikes(0);
		this.tService.create(thought);
		return "redirect:/thought/dashboard";
	}
	
	@GetMapping("/like/{id}")
	public String likeThought(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User loggedInUser = this.uService.findOneUser(userId);
		Thought likedThought = this.tService.grabOneThought(id);
		this.tService.likeThought(loggedInUser, likedThought);
		return "redirect:/thought/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlikeThought(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User loggedInUser = this.uService.findOneUser(userId);
		Thought likedThought = this.tService.grabOneThought(id);
		this.tService.unlikeThought(loggedInUser, likedThought);
		return "redirect:/thought/dashboard";
	}
}
